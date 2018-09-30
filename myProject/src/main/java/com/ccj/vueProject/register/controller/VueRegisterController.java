package com.ccj.vueProject.register.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
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
	 * */
	@RequestMapping(value="login",produces="application/json;charset=utf-8",method={RequestMethod.POST})
	@ResponseBody
	public String login(@RequestBody String body){
		log.info("用户登录");
		System.out.println(body);

		return "";
	}
}
