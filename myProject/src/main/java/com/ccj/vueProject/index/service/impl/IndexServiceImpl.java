package com.ccj.vueProject.index.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccj.vueProjec.index.dao.IndexMapper;
import com.ccj.vueProject.index.bean.IndexBean;
import com.ccj.vueProject.index.service.IndexService;
@Service
public class IndexServiceImpl implements IndexService {
	@Autowired
    IndexMapper indexMapper;
	public IndexBean getindex(String userId) {
		// TODO Auto-generated method stub
		IndexBean result = indexMapper.getindex(userId);
		return result;
	}

}
