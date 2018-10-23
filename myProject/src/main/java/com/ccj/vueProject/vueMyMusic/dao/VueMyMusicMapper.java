package com.ccj.vueProject.vueMyMusic.dao;

import java.util.List;

import com.ccj.vueProject.music.bean.MusicBean;

public interface VueMyMusicMapper {
	
	public List<MusicBean> findMyLove(String userName, int star, int end);
	
	
}
