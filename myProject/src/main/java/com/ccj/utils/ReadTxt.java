package com.ccj.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

public class ReadTxt {

private Logger log = Logger.getLogger(this.getClass().getName());
@SuppressWarnings("resource")
public String[] readTxt(String path){
	 	String[] list = null;
		try{
			System.out.println("路径"+path);
			FileInputStream file = new FileInputStream(path);
			InputStreamReader isr = new InputStreamReader(file, "UTF-8");
			BufferedReader in = new BufferedReader(isr);
			String byteread = null;
			String a = "";
            while ((byteread=in.readLine()) !=null) {  
            	a = a + byteread+" ";
            }
            list = a.split("\\s+");            
            log.info("数组长度"+list.length);
            return list;
		}catch(Exception e){
			 e.printStackTrace();
		}
		return list;
	}

}
