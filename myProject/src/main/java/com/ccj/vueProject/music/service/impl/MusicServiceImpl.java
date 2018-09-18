package com.ccj.vueProject.music.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccj.vueProject.music.bean.MusicBean;
import com.ccj.vueProject.music.dao.MusicMapper;
import com.ccj.vueProject.music.service.MusicService;
@Service("musicService")
public class MusicServiceImpl implements MusicService  {
	@Autowired
	MusicMapper musicMapper;
	public int addMusic(MusicBean musicBean){
		int index = musicMapper.addMusic(musicBean);
		return index;
	}
}
