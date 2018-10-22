package com.ccj.vueProject.vueLove.bean;

import java.util.Date;

import lombok.Data;

@Data
public class VueLoveBean {
	private int id;
	private String userName;
	private Date createTime;
	private Date updateTime;
	private int flag;
}
