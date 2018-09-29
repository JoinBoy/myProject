package com.ccj.vueProject.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccj.vueProject.user.bean.UserBean;
import com.ccj.vueProject.user.dao.UserMapper;
import com.ccj.vueProject.user.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserMapper userMapper;
	@Override
	public List<UserBean> findUser(String userName) {
		// TODO Auto-generated method stub
		List<UserBean> list = userMapper.findUser(userName);
		return list;
	}
	@Override
	public int addUser(UserBean userBean) {
		// TODO Auto-generated method stub
		int result = userMapper.addUser(userBean);
		return result;
	}

}
