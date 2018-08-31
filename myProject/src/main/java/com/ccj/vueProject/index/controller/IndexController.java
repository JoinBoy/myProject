package com.ccj.vueProject.index.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.ccj.vueProject.index.bean.IndexBean;
import com.ccj.vueProject.index.service.IndexService;
@Controller

public class IndexController {
	
	@Autowired
	IndexService indexService;
	
	private Logger log = Logger.getLogger(this.getClass().getName());
	
	@RequestMapping("/")
	public String index(HttpServletRequest request, HttpServletResponse response){
		log.info("访问首页");
		return "index/index";
	}
	@RequestMapping(value="/indexList", produces = "application/json;charset=utf-8", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String indexList(){
        List<IndexBean> indexBean = indexService.getIndex("4e0cab8b-8f68-444f-9608-5bd4abe1c7f1");
        JSONObject json = new JSONObject();
        JSONObject result = new JSONObject();
        json.put("code", 1);
        json.put("message","请求成功");
        json.put("imageUrl", indexBean);
        result.put("data", json);
		return result.toString();
	}
}
