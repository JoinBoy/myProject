package com.ccj.vueProject.user.bean;

import java.util.Date;

import lombok.Data;

@Data
public class UserBean {
	//用户id
	private String userId;
	//用户昵称
	private String userName;
	//用户密码
	private String userPassWord;
	//用户邮箱
	private String userMail;
	//创建时间
	private Date createTime;
	//token
	private String token;
	//token 创建时间
	private Date tokenCreatTime;
	//用户ip
	private String ip;
}
