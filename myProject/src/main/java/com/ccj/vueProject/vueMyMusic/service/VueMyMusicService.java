package com.ccj.vueProject.vueMyMusic.service;

import java.util.List;

import com.ccj.vueProject.music.bean.MusicBean;

public interface VueMyMusicService {
	public List<MusicBean> findMyLove(String userName,int star, int end);
}
