package com.ccj.vueProject.vueMyMusic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccj.vueProject.music.bean.MusicBean;
import com.ccj.vueProject.vueMyMusic.dao.VueMyMusicMapper;
import com.ccj.vueProject.vueMyMusic.service.VueMyMusicService;
@Service
public class VueMyMusicServiceImpl implements VueMyMusicService {
	@Autowired
	VueMyMusicMapper vueMyMusicMapper;
	@Override
	public List<MusicBean> findMyLove(String userName,int star, int end) {
		// TODO Auto-generated method stub
		List<MusicBean> result = vueMyMusicMapper.findMyLove(userName, star, end);
		return result;
	}

}
