package com.ccj.vueProject.vueLove.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.mock.MockParameterMetaData.Parameter;
import com.alibaba.fastjson.JSONObject;
import com.ccj.utils.VerifyRegister;
import com.ccj.vueProject.vueLove.bean.VueLoveBean;
import com.ccj.vueProject.vueLove.dao.VueLoveMapper;

@Controller
public class VueLoveController {
	@Autowired
	VueLoveMapper vueLoveMapper;
	private Logger log = Logger.getLogger(this.getClass().getName());
	@RequestMapping(value="/vueLove/addLove",produces="application/json;charset=utf-8",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String addLove(HttpServletRequest request,HttpServletResponse response,VueLoveBean vueLoveBean ){
		log.info("添加喜欢开始");
		VerifyRegister verifyRegister = new VerifyRegister();
		String userName = verifyRegister.verifyRegister(request);
		vueLoveBean.setUserName(userName);
		Date time = new Date(System.currentTimeMillis());
		vueLoveBean.setCreateTime(time);
		vueLoveBean.setUpdateTime(time);
		vueLoveBean.setFlag(0);
		JSONObject json = new JSONObject();
		if(!userName.isEmpty()){
			try{
				int result = vueLoveMapper.addVueLove(vueLoveBean);
				if(result>0){
					log.info("添加喜欢成功");
					json.put("code", 0);
					json.put("message", "success!");
					return json.toJSONString();
				}else{
					log.info("添加喜欢失败");
					json.put("code", 2);
					json.put("message", "插入数据库错误!");
					return json.toJSONString();
				}
			}catch(Exception e){
				log.info("添加喜欢失败");
				json.put("code", 2);
				json.put("message", "插入数据库错误!");
				return json.toJSONString();
			}
			
		}else{
			log.info("添加喜欢失败");
			json.put("code", 1);
			json.put("message", "用户名不存在");
			return json.toJSONString();
		}
	}
	@RequestMapping(value="/vueLove/removeLove", produces="aplication/json;charset=utf-8",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String removeLove(HttpServletRequest request,HttpServletResponse response, @RequestParam (required = true) int id){
		VueLoveBean vueLoveBean = new VueLoveBean();
		vueLoveBean.setId(id);
		vueLoveBean.setFlag(1);
		Date time = new Date(System.currentTimeMillis());
		vueLoveBean.setUpdateTime(time);
		JSONObject json = new JSONObject();
		try{
			int result = vueLoveMapper.removeLove(vueLoveBean);
			if(result>0){
				log.info("取消喜欢成功");
				json.put("code", 0);
				json.put("message", "取消成功");
				return json.toJSONString();
			}else{
				log.info("取消喜欢失败");
				json.put("code", 1);
				json.put("message", "取消失败");
				return json.toJSONString();
			}
		}catch(Exception e){
			log.info("取消喜欢失败");
			json.put("code", 1);
			json.put("message", "取消失败");
			return json.toJSONString();
		}
	}
}
