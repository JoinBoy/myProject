package com.ccj.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import com.ccj.vueProject.music.bean.MusicBean;



public class YyMp3 {	
	public List<MusicBean> findYyMp3(String name , int page){
		List<MusicBean> list = new ArrayList<MusicBean>();
		
		try {
			String nameUrl = URLEncoder.encode(name,"UTF-8");
			URL url = new URL("http://www.yymp3.com/p/getser.aspx?key="+nameUrl+"&page="+page);
			System.out.println(url.toString());

			HttpURLConnection http = (HttpURLConnection)url.openConnection();
			http.setDoOutput(true);// 使用 URL 连接进行输出
			http.setDoInput(true);// 使用 URL 连接进行输入
			http.setUseCaches(false);// 忽略缓存
			http.setRequestProperty("accept", "*/*");
			http.setRequestProperty("connection", "Keep-Alive");
			http.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2526.106 Safari/537.36");
			int responseCode = http.getResponseCode();
			System.out.println("状态"+responseCode);
			String readLine = null;
			if (HttpURLConnection.HTTP_OK == responseCode) {// 连接成功
				// 当正确响应时处理数据
				StringBuffer sb = new StringBuffer();
				BufferedReader responseReader;
				// 处理响应流，必须与服务器响应流输出的编码一致
				
				responseReader = new BufferedReader(new InputStreamReader(http.getInputStream(), "UTF-8"));
				while ((readLine = responseReader.readLine()) != null) {
					sb.append(readLine).append("\n");
				}
				responseReader.close();
				String results = sb.toString();
				String result = results.replace("wma", "mp3");
				String result1 = result.substring(result.indexOf("$song_data[3]=")+15, result.indexOf(";song_list")-1);
				if(!"".equals(result1)){
					String[] strs=result1.split("\\|\\|");
					for(int i=0;i<strs.length;i++){
						String[] str1 = strs[i].split("\\|");
						System.out.println(str1[1]+"  "+str1[3]+"  "+str1[4]);
						System.out.print("  歌曲名==>"+str1[1]);
						System.out.println("  歌手"+str1[3]);
						System.out.println("<========歌曲URL=======>"+str1[4]);
						MusicBean musicBean = new MusicBean();
						musicBean.setSongerName(str1[3]);
						Date time = new Date(System.currentTimeMillis());
						long t1=System.currentTimeMillis();
						musicBean.setMusicId(String.valueOf(t1));
						musicBean.setMusicName(str1[1]);
						musicBean.setMusicUrl("http://ting666.yymp3.com:86/"+str1[4]);
						musicBean.setCreateTime(time);
						musicBean.setUpdateTime(time);
						System.out.println(musicBean.toString());
						list.add(musicBean);
					}
				}else{
					System.out.println("=======================");
					System.out.println("完成");
					System.out.println("=======================");
				}
				return list;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return list;
		}
		return list;
	}
}
