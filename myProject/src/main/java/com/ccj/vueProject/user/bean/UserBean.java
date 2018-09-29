package com.ccj.vueProject.user.bean;

import java.util.Date;

import lombok.Data;

@Data
public class UserBean {
	private String userName;
	private String userPassWord;
	private String userMail;
	private Date createTime;
}
