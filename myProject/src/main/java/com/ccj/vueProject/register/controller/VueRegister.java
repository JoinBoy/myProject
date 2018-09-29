package com.ccj.vueProject.register.controller;

import java.util.Date;
import java.util.List;

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


@Controller
public class VueRegister {
	
	private Logger log = Logger.getLogger(this.getClass().getName());
	@Autowired
	UserService userService;
	@RequestMapping(value="/register", produces="application/json;charset=utf-8",method={RequestMethod.GET})
	public String Register(){
		log.info("访问登录注册页面");
		return "vue/register/register";
	}
	
	@RequestMapping(value="/registerList",produces="application/json;charet=utf-8",method={RequestMethod.POST})
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
	
}
