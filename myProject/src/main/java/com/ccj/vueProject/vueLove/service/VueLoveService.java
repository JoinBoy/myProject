package com.ccj.vueProject.vueLove.service;

import java.util.List;

import com.ccj.vueProject.vueLove.bean.VueLoveBean;

public interface VueLoveService {
	int addVueLove(VueLoveBean vueLoveBean);
	int removeLove(VueLoveBean vueLoveBean);
	List<Integer> findLove(String userName);
}
