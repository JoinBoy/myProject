package com.ccj.utils;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ccj.vueProject.user.dao.UserMapper;
@Component
public class VerifyRegister {
	@Autowired
	UserMapper usermapper;
	public static VerifyRegister verifyRegister;
	@PostConstruct
    public void init() {
		verifyRegister = this;
    }
	@SuppressWarnings("unused")
	public String verifyRegister(HttpServletRequest request){
		HttpSession session = request.getSession();
		String sessionIP = (String) session.getAttribute("IP");
		Cookie[] cookies = request.getCookies();
		String cookieValue = null;
		String userName = null;
		String ip = "IP";
		String userNameString = "userName";
		for(Cookie cookie : cookies){ //获得cookie中IP的值
			if(cookie.getName().equals(ip)){
				cookieValue = cookie.getValue();
			}
			if(cookie.getName().equals(userNameString)){
				try {
					userName = URLDecoder.decode(cookie.getValue(), "utf-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					return "";
				}
			}
		}
		if(cookieValue!=null){//判断cookie是否存在
			if(sessionIP!=null){//判断 session中的IP是否为空
				if(sessionIP.equals(cookieValue)){//判断session中的ip是不是和cookie中的ip相等
					return userName;
				}else{
					/*session中的ip是不是和cookie中的ip不相等返回空（之后跳转登录）*/
					return "";
				}
				
			}else{
				/*session中不存在IP就用用户名和cookie中的ip去判断用户是否正确
				 * 如果正确添加session并返回用户名，不正确返回空字符串（跳转登录）*/
				String username = verifyRegister.usermapper.findUserLogAgain(userName, cookieValue);
				if(userName!=null){
					return userName;
				}else{
					return "";
				}
				
			}
		}else{
			return "";
		}

	} 
	
	
}
