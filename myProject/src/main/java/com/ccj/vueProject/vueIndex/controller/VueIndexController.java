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
import com.ccj.utils.VerifyRegister;
import com.ccj.vueProject.music.bean.MusicBean;
import com.ccj.vueProject.vueIndex.service.VueIndexService;
import com.ccj.vueProject.vueLove.service.VueLoveService;

@Controller
public class VueIndexController {
	@Autowired
	VueIndexService vueIndexService;
	@Autowired
	VueLoveService vueLoveService;
	private Logger log = Logger.getLogger(this.getClass().getName());
	@RequestMapping(value="/vueIndex",produces = "application/json;charset=utf-8",method = {RequestMethod.GET})
	public String indexPage(HttpServletRequest request, HttpServletResponse response){
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
			VerifyRegister verifyRegister = new VerifyRegister();
			String userName = verifyRegister.verifyRegister(request);
			List<MusicBean> recommend = vueIndexService.getRecommend(recommendSize);
			List<MusicBean> playList = vueIndexService.getPlay(playSize);
			if(!userName.isEmpty()){
				List<Integer> ids = vueLoveService.findLove(userName);
				for(Integer id : ids){
					for(MusicBean bean :recommend){
						if(bean.getSongerId() == id){
							bean.setLove(0);
							System.out.println("+++++++++++++++++++++");
						}
					}
					for(MusicBean bean: playList){
						if(bean.getSongerId() == id){
							bean.setLove(0);
						}
					}
				}
				json.put("code", 0);
				json.put("message", "success");
				JSONObject list = new JSONObject();
				list.put("recommend", recommend);
				list.put("playList",playList);
				list.put("userName", userName);
				json.put("list", list);
				return json.toJSONString();
			}else{
				json.put("code", 0);
				json.put("message", "success");
				JSONObject list = new JSONObject();
				list.put("recommend", recommend);
				list.put("playList",playList);
				list.put("userName", userName);
				json.put("list", list);
				return json.toJSONString();
			}
		}catch(Exception e){
			e.fillInStackTrace();
			json.put("code", 1);
			json.put("message", "fail");
			return json.toJSONString();
		}		
	}
}
