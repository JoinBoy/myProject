package com.ccj.vueProject.register.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.ccj.utils.GetIpAddr;
import com.ccj.vueProject.user.bean.UserBean;
import com.ccj.vueProject.user.service.UserService;
import com.ccj.vueProject.verificationCode.bean.VerificationCode;


@Controller
public class VueRegisterController {
	/**
	 * 访问登录页面
	 * */
	private Logger log = Logger.getLogger(this.getClass().getName());
	@Autowired
	UserService userService;
	@RequestMapping(value="/register", produces="application/json;charset=utf-8",method={RequestMethod.GET})
	public String Register(HttpServletRequest request , HttpServletResponse response){
		HttpSession session = request.getSession();
		session.setAttribute("lastUrl", request.getHeader("Referer"));
		log.info("访问登录注册页面");
		return "vue/register/register";
	}
	/**
	 * 用户注册逻辑
	 * */
	@RequestMapping(value="/registerList",produces="application/json;charset=utf-8",method={RequestMethod.POST})
	@ResponseBody
	public JSONObject registerList(@RequestBody UserBean userBean){
		log.info("查询用户名是否存在");
		List<UserBean> list = userService.findUser(userBean.getUserName());
		JSONObject json = new JSONObject();
		if(list.size()>0){
			json.put("code", 1);
			json.put("message", "用户名已存在！");
			return json;
		}else{
			Date time = new Date(System.currentTimeMillis());
			userBean.setCreateTime(time);
			int result = userService.addUser(userBean);
			if(result>0){
				json.put("code", 0);
				json.put("message", "注册成功");
				
				return json;
			}else{
				json.put("code", 1);
				json.put("message", "注册失败！");
				return json;
			}			
		}
	}
	/**
	 * 获得验证码
	 * */
	@RequestMapping(value="verificationCode",produces="application/json;charset=utf-8",method={RequestMethod.GET})
	@ResponseBody
	public String verificationCode(HttpServletRequest request,HttpServletResponse response){
		log.info("获取验证码");
		int[] code = {(int) Math.floor(Math.random()*10),(int) Math.floor(Math.random()*10),(int) Math.floor(Math.random()*10),(int) Math.floor(Math.random()*10)};
		JSONObject json = new JSONObject();
		VerificationCode verificationCode = new VerificationCode();
		String codeStr="";
		for(int i = 0;i<code.length;i++){
			codeStr+=code[i];
		}
		verificationCode.setCode(codeStr);
		Date createTime = new Date(System.currentTimeMillis());
		verificationCode.setCreateTime(createTime);
		verificationCode.setFlage(true);
		String sessionId = request.getSession().getId();
		verificationCode.setSessionId(sessionId);
		String userIp = request.getRemoteAddr();
		verificationCode.setUserIp(userIp);
		int result = userService.addCode(verificationCode);
		if(result>0){
			json.put("code", 0);
			json.put("message", "sucess");
			json.put("data",code);
			return json.toString();
		}else{
			json.put("code", 1);
			json.put("message", "获取验证码失败！");
			return json.toString();
		}
	}
	/**
	 * 用户登录逻辑
	 * @throws IOException 
	 * */
	@RequestMapping(value="login",produces="application/json;charset=utf-8",method={RequestMethod.POST})
	@ResponseBody
	public String login(HttpServletRequest request,HttpServletResponse response,  @RequestParam(required = false) String userName,@RequestParam(required = false) String userPassWord,@RequestParam(required = false) String verification) throws IOException{
		log.info("用户登录");
		/*设置验证码有效期为n分钟*/
		String interval = "5";
		JSONObject json = new JSONObject();
		VerificationCode verificationCode = userService.findCode(verification,interval);
		if(verificationCode != null){
			UserBean userBean = userService.findUserLog(userName, userPassWord);
			if(userBean !=null){
				HttpSession session = request.getSession();
				session.setAttribute("userName",userName);
				String sessionId = session.getId();
				/*获得当前时间*/
				Date date = new Date(System.currentTimeMillis());
				/*格式化时间*/
				SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String Ip = new GetIpAddr().getIpAddr(request);
				int result = userService.addToken(sessionId, sdf2.format(date), userName ,Ip);
				if(result>0){
					String lastUrl = (String) session.getAttribute("lastUrl");
					session.removeAttribute("lastUrl");
					session.setAttribute("IP", Ip);
					Cookie cookie = new Cookie("userName",URLEncoder.encode(userName,"utf-8"));
					Cookie IpCookie = new Cookie("IP",Ip);
					/*设置cookie为7天*/
					IpCookie.setMaxAge(3600*24*7);
					cookie.setMaxAge(3600*24*7);
					response.addCookie(cookie);
					response.addCookie(IpCookie);
					json.put("code", 0);
					json.put("message", "登陆成功！");
					log.info("用户登录成功！,用户名="+userName);
					json.put("lastUrl", lastUrl);
					return json.toJSONString();
				}else{
					json.put("code", 1);
					json.put("message", "登录失败！");
					log.info("登录失败！,用户名="+userName);
					return json.toJSONString();
				}
				
			}else{
				json.put("code", 1);
				json.put("message", "用户名或密码错误！");
				log.info("用户名或密码错误！,用户名="+userName);
				return json.toJSONString();
			}
		}else{
			json.put("code", 1);
			json.put("message", "验证码错误！");
			log.info("验证码错误！,用户名="+userName);
			return json.toJSONString();
		}			
	}
	/**
	 * 用户注销逻辑
	 * */
	@RequestMapping(value="/logout", produces="application/json;charset=utf-8",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String logout(HttpServletRequest request,HttpServletResponse response){
		JSONObject json = new JSONObject();
		try{
			Cookie[] cookies = request.getCookies();
			if( cookies != null){
				for(Cookie cookie : cookies){
					if(cookie.getName().equals("userName")){
						System.out.println(cookie.getName());
						cookie.setMaxAge(0);
						cookie.setValue(null);
						response.addCookie(cookie);
					}
					if(cookie.getName().equals("IP")){
						cookie.setMaxAge(0);
						cookie.setValue(null);
						response.addCookie(cookie);
					}
				}
			}
			HttpSession session = request.getSession();
			session.removeAttribute("IP");
			json.put("code", 0);
			json.put("message","success");
			return json.toJSONString();
		}catch(Exception e ){
			json.put("code", 1);
			json.put("message","failed");
			return json.toJSONString();
		}
	}
}
