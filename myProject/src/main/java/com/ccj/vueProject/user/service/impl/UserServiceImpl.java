package com.ccj.vueProject.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccj.vueProject.user.bean.UserBean;
import com.ccj.vueProject.user.dao.UserMapper;
import com.ccj.vueProject.user.service.UserService;
import com.ccj.vueProject.verificationCode.bean.VerificationCode;
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
	@Override
	public int addCode(VerificationCode verificationCode) {
		// TODO Auto-generated method stub
		int result = userMapper.addCode(verificationCode);
		return result;
	}
	@Override
	public VerificationCode findCode(String verification,String interval) {
		VerificationCode verificationCode = userMapper.findCode(verification,interval);
		return verificationCode;
	}
	@Override
	public UserBean findUserLog(String userName, String userPassWord) {
		UserBean userBean = userMapper.findUserLog(userName, userPassWord);
		return userBean;
	}
	@Override
	public int addToken(String token, String tokenCteatTime, String userName) {
		int result = userMapper.addToken(token, tokenCteatTime, userName);
		return result;
	}

}
