package com.ccj.vueProject.vueLove.dao;

import java.util.List;

import com.ccj.vueProject.vueLove.bean.VueLoveBean;

public interface VueLoveMapper {
	
	int addVueLove(VueLoveBean vueLoveBean);
	int removeLove(VueLoveBean vueLoveBean);
	List<Integer> findLove(String userName);
}
