package com.ccj.vueProject.music.bean;



import java.util.Date;

import lombok.Data;

@Data
public class MusicBean {
	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;
	//歌曲id
	private String musicId;
	//歌手名
	private String songerName;
	//歌曲名
	private String musicName;
	//歌曲Url
	private String musicUrl;
	//创建时间
	private Date createTime;
	//更新时间
	private Date updateTime;

}
