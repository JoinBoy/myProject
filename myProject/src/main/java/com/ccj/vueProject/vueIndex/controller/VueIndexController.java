package com.ccj.vueProject.vueIndex.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.ccj.vueProject.music.bean.MusicBean;
import com.ccj.vueProject.vueIndex.service.VueIndexService;

@Controller
public class VueIndexController {
	@Autowired
	VueIndexService vueIndexService;
	private Logger log = Logger.getLogger(this.getClass().getName());
	@RequestMapping(value="/vueIndex",produces = "application/json;charset=utf-8",method = {RequestMethod.GET})
	public String indexPage(){
		log.info("访问VUE项目主页");		
		return "vue/vueIndex/vueIndex";
	};
	
	/*获取初始化数据*/
	@RequestMapping(value="/getVueIndexList",produces = "application/json;charset=utf-8",method ={RequestMethod.POST})
	@ResponseBody
	public String getVueIndexList(HttpServletRequest request,HttpServletResponse response,@RequestParam(required = true) int recommendSize,@RequestParam(required = true) int playSize){
		log.info("获得VueIndex页面初始化数据");
		JSONObject json = new JSONObject();
		try{
			List<MusicBean> recommend = vueIndexService.getRecommend(recommendSize);
			List<MusicBean> playList = vueIndexService.getPlay(playSize);
			json.put("code", 0);
			json.put("message", "success");
			JSONObject list = new JSONObject();
			list.put("recommend", recommend);
			list.put("playList",playList);
			json.put("list", list);
			return json.toJSONString();
		}catch(Exception e){
			json.put("code", 1);
			json.put("message", "fail");
			return json.toJSONString();
		}
		
	}
	
	
	
}
