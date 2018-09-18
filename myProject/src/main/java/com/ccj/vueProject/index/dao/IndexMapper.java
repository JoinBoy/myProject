package com.ccj.vueProject.index.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ccj.vueProject.index.bean.IndexBean;
@Repository
public interface IndexMapper {
	public List<IndexBean> getIndex(String userId);
}
