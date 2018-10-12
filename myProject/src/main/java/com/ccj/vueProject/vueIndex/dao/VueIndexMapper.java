package com.ccj.vueProject.vueIndex.dao;

import java.util.List;

import com.ccj.vueProject.music.bean.MusicBean;

public interface VueIndexMapper {
	public List<MusicBean> getRecommend(int recommendSize);
	public List<MusicBean> getPlay(int playSize);
}
