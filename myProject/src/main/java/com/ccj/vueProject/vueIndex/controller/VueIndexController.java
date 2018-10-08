package com.ccj.vueProject.vueIndex.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/my")
public class VueIndexController {
	private Logger log = Logger.getLogger(this.getClass().getName());
	@RequestMapping(value="/vueIndex",produces = "application/json;charset=utf-8",method = {RequestMethod.GET})
	public String indexPage(){
		log.info("访问VUE项目主页");		
		return "vue/vueIndex/vueIndex";
	}
}
