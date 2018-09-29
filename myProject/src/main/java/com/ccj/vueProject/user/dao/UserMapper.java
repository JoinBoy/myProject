package com.ccj.vueProject.user.dao;

import java.util.List;

import com.ccj.vueProject.user.bean.UserBean;

public interface UserMapper {
	public List<UserBean> findUser(String userName);
	public int addUser(UserBean userBean);
}
