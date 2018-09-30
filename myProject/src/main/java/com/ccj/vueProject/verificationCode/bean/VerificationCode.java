package com.ccj.vueProject.verificationCode.bean;

import java.util.Date;

import lombok.Data;
@Data
public class VerificationCode {
	private String code;
	private Date createTime;
	private String sessionId;
	private Boolean flage;
	private String userIp;
}
