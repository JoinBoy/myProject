package com.ccj.vueProject.myCenter.controller;


import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ccj.filter.UserLogined;

@Controller
@RequestMapping(value="/myCenter")
public class AddBook {
	@UserLogined()
	@RequestMapping(value = "/addBook", produces="application/json;charset=utf-8",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String addBook(MultipartFile file,HttpServletRequest request){
		String name = file.getOriginalFilename();
		//获得文件扩展名
		String suffix = name.substring(name.lastIndexOf("."));
		//获得当前毫秒数
		String dataTimes = Long.toString(System.currentTimeMillis());
		//图片存储名称
		String imgLastName = dataTimes + suffix;
		System.out.println(dataTimes);
		//获得服务器路径
		String serverPath = request.getServletContext().getRealPath("/");
		//图片存储路径
		String imgSavePath = serverPath+"images/";
		File targetFile = new File(imgSavePath, imgLastName);
		if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(request.getServletContext().getRealPath("/"));
		return "";
	} 
	
	
}