package com.ccj.vueProject.vueMyMusic.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.ccj.vueProject.vueMyMusic.service.VueMyMusicService;

@Controller
public class VueMyMusicController {
	@Autowired
	VueMyMusicService vueMyMusicService;
	@Autowired
	VueIndexService vueIndexService;
	@Autowired
	VueLoveService vueLoveService;
	private Logger log = Logger.getLogger(this.getClass().getName());
	@RequestMapping(value="/vueMyMusic")
	public String vueMyMusic(){
		log.info("访问我的音乐页面");
		return "vue/vueMyMusic/vueMyMusic";
	}
	
	@RequestMapping(value="/vueMyMusic/getList", produces="application/json;charset=utf-8",method = {RequestMethod.POST,RequestMethod.GET} )
	@ResponseBody
	public String getList(@RequestParam(required = true) int page,HttpServletRequest request){
		log.info("获得VueMyMusic页面初始化数据");
		JSONObject json = new JSONObject();
		final int LONGS = 10; //每页显示10条
		int star = (page-1)*10;
		try{
			VerifyRegister verifyRegister = new VerifyRegister();
			String userName = verifyRegister.verifyRegister(request);
			List<MusicBean> loved = vueMyMusicService.findMyLove(userName, star, LONGS);
			List<MusicBean> playList = vueIndexService.getPlay(10);
			if(!userName.isEmpty()){
				List<Integer> ids = vueLoveService.findLove(userName);
				for(Integer id : ids){
					for(MusicBean bean: playList){
						if(bean.getSongerId() == id){
							bean.setLove(1);
						}
					}
				}
				json.put("code", 0);
				json.put("message", "success");
				JSONObject list = new JSONObject();
				list.put("loved", loved);
				list.put("playList",playList);
				list.put("userName", userName);
				json.put("list", list);
				return json.toJSONString();
			}else{
				json.put("code", 0);
				json.put("message", "success");
				JSONObject list = new JSONObject();
				list.put("loved", loved);
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
