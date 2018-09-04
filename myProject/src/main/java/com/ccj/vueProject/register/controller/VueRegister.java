package com.ccj.vueProject.register.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class VueRegister {
	
	private Logger log = Logger.getLogger(this.getClass().getName());
	
	@RequestMapping(value="/register", produces="application/json;charset=utf-8",method={RequestMethod.GET})
	public String Register(){
		return "vue/register";
	}

}
