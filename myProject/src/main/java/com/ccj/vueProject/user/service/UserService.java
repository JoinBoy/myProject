package com.ccj.vueProject.user.service;

import java.util.List;

import com.ccj.vueProject.user.bean.UserBean;
import com.ccj.vueProject.verificationCode.bean.VerificationCode;

public interface UserService {
	public List<UserBean> findUser(String userName);
	public int addUser(UserBean userBean);
	public int addCode(VerificationCode verificationCode);
	public VerificationCode findCode(String verification,String interval);
	public UserBean findUserLog(String userName,String userPassWord);
	public int addToken(String token,String tokenCteatTime, String userName ,String Ip);
}
