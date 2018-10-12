package com.ccj.vueProject.vueIndex.service;

import java.util.List;

import com.ccj.vueProject.music.bean.MusicBean;

public interface VueIndexService {
	public List<MusicBean> getRecommend(int recommendSize);
	public List<MusicBean> getPlay(int playSize);
}
