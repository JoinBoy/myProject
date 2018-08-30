package com.ccj.vueProjec.index.dao;

import org.springframework.stereotype.Repository;

import com.ccj.vueProject.index.bean.IndexBean;
@Repository
public interface IndexMapper {
	IndexBean getindex(String userId);
}
