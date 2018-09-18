package com.ccj.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ccj.vueProject.music.bean.MusicBean;

public class QqMusicFindMusicMessage {
	private Logger log = Logger.getLogger(this.getClass().getName());
	public List<MusicBean> findMusicMessage(String name){
		List<MusicBean> list = new ArrayList<MusicBean>();
		JSONObject json = new JSONObject();
		// 建立连接
		try {
			System.out.println("歌手名字"+name);
			String nameUrl = URLEncoder.encode(name,"UTF-8");
			URL url = new URL("https://c.y.qq.com/soso/fcgi-bin/client_search_cp?ct=24&qqmusic_ver=1298&new_json=1&remoteplace=txt.yqq.song&searchid=66007024532902673&t=0&aggr=1&cr=1&catZhida=1&lossless=0&flag_qc=0&p=1&n=1000&w="+nameUrl+"&g_tk=5381&jsonpCallback=MusicJsonCallback9361426476224415&loginUin=0&hostUin=0&format=jsonp&inCharset=utf8&outCharset=utf-8&notice=0&platform=yqq&needNewCode=0");
			HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
			// 设置连接属性
			httpUrlConnection.setDoOutput(true);// 使用 URL 连接进行输出
			httpUrlConnection.setDoInput(true);// 使用 URL 连接进行输入
			httpUrlConnection.setUseCaches(false);// 忽略缓存
			
			httpUrlConnection.setRequestMethod("GET");// 设置URL请求方法
			httpUrlConnection.setRequestProperty("CHARSET", "UTF-8");
			// 设置请求属性
			// 获得数据字节数据，请求数据流的编码，必须和下面服务器端处理请求流的编码一致
			httpUrlConnection.setRequestProperty("Content-Type", "application/json");
			httpUrlConnection.setRequestProperty("Connection", "Keep-Alive");// 维持长连接
			httpUrlConnection.setRequestProperty("Charset", "UTF-8");
			// 获得响应状态
			int responseCode = httpUrlConnection.getResponseCode();
			String readLine = null;
			if (HttpURLConnection.HTTP_OK == responseCode) {// 连接成功
				// 当正确响应时处理数据
				StringBuffer sb = new StringBuffer();
				System.out.println("连接成功");
				BufferedReader responseReader;
				// 处理响应流，必须与服务器响应流输出的编码一致
				responseReader = new BufferedReader(new InputStreamReader(httpUrlConnection.getInputStream(), "UTF-8"));
				while ((readLine = responseReader.readLine()) != null) {
					sb.append(readLine).append("\n");
				}
				responseReader.close();
				String result = sb.toString();
				int index = result.indexOf("(");
				result = result.substring(index+1);
				result = result.replace(")", "");
				// 处理返回的参数
				if (!"".equals(result)) {
					json = JSONObject.parseObject(result);
					JSONObject ss = json.getJSONObject("data").getJSONObject("song");
					int totalnum = 	ss.getIntValue("totalnum");
					JSONArray a = (JSONArray) ss.get("list");
					System.out.println("歌曲总数目==》"+totalnum);
					System.out.println("当前请求歌曲数目==》"+a.size());
					for(int i =0;i<a.size();i++){
						JSONObject r = (JSONObject)a.get(i);
						QqMusicFindMusicUrl qqMusicFindMusicUrl = new QqMusicFindMusicUrl();
						String musicUrl = qqMusicFindMusicUrl.findMusicUrl(r.get("mid").toString());
						if(musicUrl != "失败"){
							System.out.print("  歌曲名==>"+r.get("name"));
							System.out.print("  歌曲id==>"+r.get("mid"));
							JSONArray y =(JSONArray)r.get("singer");
							JSONObject z = (JSONObject)y.get(0);
							System.out.println("  歌手"+z.get("name"));
							System.out.println("<========歌曲URL=======>"+musicUrl);
							MusicBean musicBean = new MusicBean();
							musicBean.setSongerName(z.get("name").toString());
							musicBean.setMusicId(r.get("mid").toString());
							musicBean.setMusicName(r.get("name").toString());
							musicBean.setMusicUrl(musicUrl);
							Date time = new Date(System.currentTimeMillis());
							musicBean.setCreateTime(time);
							musicBean.setUpdateTime(time);
							System.out.println(musicBean.toString());
							list.add(musicBean);
						}					
					}
				}
			}else{
				System.out.println("链接失败");
			}
			
			json.put("HTTP_CODE", responseCode);
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println(e);
			return list;
		}
		return list;
	}	
}
