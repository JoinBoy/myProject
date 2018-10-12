package com.ccj.vueProject.music.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ccj.utils.ReadTxt;
import com.ccj.utils.YyMp3;
import com.ccj.vueProject.music.bean.MusicBean;
import com.ccj.vueProject.music.service.MusicService;
@Controller
public class YymusicController {
	@Autowired
	MusicService musicService;
	@RequestMapping(value="/indexyyyy", produces = "application/json;charset=utf-8", method = {RequestMethod.POST,RequestMethod.GET})
	public void addMusicController(){
		ReadTxt readTxt = new ReadTxt();
		String[] readList = readTxt.readTxt("C:\\\\歌手名77.txt");
		for(int i=0;i<readList.length;i++){
			YyMp3 yyMp3 = new YyMp3();
			System.out.println(22);
			List<MusicBean> list = yyMp3.findYyMp3(readList[i],2);
			for(int j=0;j<list.size();j++){
				System.out.println("1111"+list.get(j).getMusicName());
				int w = musicService.addMusic(list.get(j));
			}
		}
		
	}
}