package com.ccj.vueProject.music.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ccj.utils.QqMusicFindMusicMessage;
import com.ccj.utils.ReadTxt;
import com.ccj.vueProject.music.bean.MusicBean;
import com.ccj.vueProject.music.service.MusicService;
@Controller
public class MusicController {
	@Autowired
	MusicService musicService;
	@RequestMapping(value="/indexaaa", produces = "application/json;charset=utf-8", method = {RequestMethod.POST,RequestMethod.GET})
	public void addMusicController(){
		ReadTxt readTxt = new ReadTxt();
		String[] readList = readTxt.readTxt("C:\\\\添加.txt");
		for(int i=0;i<readList.length;i++){
			QqMusicFindMusicMessage musicMessage = new QqMusicFindMusicMessage();
			List<MusicBean> list = musicMessage.findMusicMessage(readList[i]);
			for(int j=0;j<list.size();j++){
				int w = musicService.addMusic(list.get(j));
			}
		}
		
	}
}
