package com.ccj.vueProject.vueLove.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccj.vueProject.vueLove.bean.VueLoveBean;
import com.ccj.vueProject.vueLove.dao.VueLoveMapper;
import com.ccj.vueProject.vueLove.service.VueLoveService;
@Service
public class VueLoveServiceImpl implements VueLoveService {
	@Autowired
	VueLoveMapper vueLoveMapper;
	@Override
	public int addVueLove(VueLoveBean vueLoveBean) {
		// TODO Auto-generated method stub
		int result = vueLoveMapper.addVueLove(vueLoveBean);
		return result;
	}
	@Override
	public int removeLove(VueLoveBean vueLoveBean) {
		// TODO Auto-generated method stub
		int result = vueLoveMapper.removeLove(vueLoveBean);
		return result;
	}
	@Override
	public List<Integer> findLove(String userName) {
		// TODO Auto-generated method stub
		List<Integer> result = vueLoveMapper.findLove(userName);
		return result;
	}

}
