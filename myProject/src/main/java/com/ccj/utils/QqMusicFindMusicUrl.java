package com.ccj.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

//根据歌曲id获得歌曲url
public class QqMusicFindMusicUrl {
	
	public String findMusicUrl(String musicId){
		try{
			URL url = new URL("https://u.y.qq.com/cgi-bin/musicu.fcg?callback=getplaysongvkey24869687273547125&g_tk=5381&jsonpCallback=getplaysongvkey24869687273547125&loginUin=0&hostUin=0&format=jsonp&inCharset=utf8&outCharset=utf-8&notice=0&platform=yqq&needNewCode=0&data=%7B%22req_0%22%3A%7B%22module%22%3A%22vkey.GetVkeyServer%22%2C%22method%22%3A%22CgiGetVkey%22%2C%22param%22%3A%7B%22guid%22%3A%228475853515%22%2C%22songmid%22%3A%5B%22"+musicId+"%22%5D%2C%22songtype%22%3A%5B0%5D%2C%22uin%22%3A%220%22%2C%22loginflag%22%3A1%2C%22platform%22%3A%2220%22%7D%7D%2C%22comm%22%3A%7B%22uin%22%3A0%2C%22format%22%3A%22json%22%2C%22ct%22%3A20%2C%22cv%22%3A0%7D%7D");
			HttpsURLConnection http = (HttpsURLConnection)url.openConnection();
			http.setDoOutput(true);// 使用 URL 连接进行输出
			http.setDoInput(true);// 使用 URL 连接进行输入
			http.setUseCaches(false);// 忽略缓存
			http.setRequestProperty("Content-Type", "application/json");
			http.setRequestProperty("Connection", "Keep-Alive");// 维持长连接
			http.setRequestProperty("Charset", "UTF-8");
			int responseCode = http.getResponseCode();
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
				String result = sb.toString();
				System.out.println(result);
				int index = result.indexOf("(");
				result = result.substring(index+1);
				result = result.replace(")", "");
				// 处理返回的参数
				if (!"".equals(result)) {
					JSONObject json = JSONObject.parseObject(result);
					String url0 = null;
					JSONObject o = json.getJSONObject("req");
					if(o == null){
						url0 = "http://42.81.125.13/amobile.music.tc.qq.com/";
					}else{						
						JSONArray json1 = json.getJSONObject("req").getJSONObject("data").getJSONArray("freeflowsip");
						url0 = json1.getString(0);
					}
					JSONArray json2 = json.getJSONObject("req_0").getJSONObject("data").getJSONArray("midurlinfo");
					JSONObject json3 = (JSONObject)json2.get(0);
					String url1 = json3.getString("purl");
					if(url1.isEmpty()){
						//不能播放的
					}else{
						return url0+url1;
					}				
				}
			}else{
				System.out.println("链接失败");
				return "失败";
			}
		}catch(Exception e){
			System.out.println("异常");
			return "失败";
		}
		return "失败";
	}
	public void main(String[] args){
		findMusicUrl("11");
	}
	
}
