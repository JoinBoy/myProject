package com.ccj.vueProject.index.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ccj.vueProject.index.bean.IndexBean;
import com.ccj.vueProject.index.dao.IndexMapper;
import com.ccj.vueProject.index.service.IndexService;
@Service
public class IndexServiceImpl implements IndexService {
	@Autowired
    IndexMapper indexMapper;
	public List<IndexBean> getIndex(String userId) {
		// TODO Auto-generated method stub
		List<IndexBean> result = indexMapper.getIndex(userId);
		return result;
	}

}
