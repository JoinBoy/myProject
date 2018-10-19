package com.ccj.vueProject.vueIndex.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccj.vueProject.music.bean.MusicBean;
import com.ccj.vueProject.vueIndex.dao.VueIndexMapper;
import com.ccj.vueProject.vueIndex.service.VueIndexService;
@Service("VueIndexService")
public class VueIndexServiceImpl implements VueIndexService {
	@Autowired
	VueIndexMapper vueIndexMapper;
	@Override
	public List<MusicBean> getRecommend(int recommendSize) {
		List<MusicBean> recommend = vueIndexMapper.getRecommend(recommendSize);
		return recommend;
	}
	@Override
	public List<MusicBean> getPlay(int playSize) {
		List<MusicBean> playList= vueIndexMapper.getRecommend(playSize);
		return playList;
	}
}
