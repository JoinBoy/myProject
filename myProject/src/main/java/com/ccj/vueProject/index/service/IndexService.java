package com.ccj.vueProject.index.service;

import java.util.List;

import com.ccj.vueProject.index.bean.IndexBean;

public interface IndexService {
	List<IndexBean> getIndex(String userId);
}
