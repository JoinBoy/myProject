package com.ccj.vueProject.index.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.ccj.vueProject.index.bean.IndexBean;
import com.ccj.vueProject.index.service.IndexService;
@Controller

public class IndexController {
	
	@Autowired
	IndexService indexService;
	@RequestMapping("/index")
	public String index(HttpServletRequest request, HttpServletResponse response){
		return "index/index";
	}
	@RequestMapping("/indexList")
	@ResponseBody
	public String indexList(HttpServletRequest request, HttpServletResponse response){
        JSONObject json = new JSONObject();
        IndexBean indexBean = indexService.getindex("4e0cab8b-8f68-444f-9608-5bd4abe1c7f1");
        json = (JSONObject) JSONObject.toJSON(indexBean);
		return json.toString();
	}
}
