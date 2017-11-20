package com.ajashop.web.common.util;

/**
 * First Editor : dereklee
 * Last Editor  : dereklee
 * Date         : 2017-07-30
 * Description  :
 * Copyright ⓒ 2013-2015 dereklee All rights reserved.
 * version      : v0.1
 */

import java.io.File;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartFile;

public class MultipartUtil {

	public static String copyFile(MultipartFile mutiFile, String path, String fileName) {
		if(mutiFile == null) return null;
		
		try {
			fileName = fileName + "." + getFileExtension(mutiFile.getOriginalFilename());
			File file = new File(path+"/"+fileName);
			
			mutiFile.transferTo(file);
			
			return file.getPath();
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
//	public static String copyFileNotNull(MultipartFile mutiFile, String filedName, String path, String fileName) throws Exception {
//		
//		fileName = fileName + "." + getFileExtension(mutiFile.getOriginalFilename());
//		File file = new File(path+"/"+fileName);
//		
//		mutiFile.transferTo(file);
//		
//		return file.getPath();
//	}
	
	public static String getFileExtension(String fileName) {
		return fileName.substring( fileName.lastIndexOf( "." ) + 1 );
	}
	
	public static void save(MultipartFile multipartFile, String path, String fileName) throws Exception {
		if(multipartFile == null) throw new NullPointerException("업로드된 파일정보가 없습니다.");
		
		checkDirectory(path);
		
		File file = new File(path + "/" + fileName);
		multipartFile.transferTo(file);
	}
	
	public static void checkDirectory(String path) {
		String[] directorys = StringUtils.split(path, "/");
		String tempPath = ""; 
		for(int i = 0;i<directorys.length;i++) {
			tempPath = tempPath + "/" + directorys[i];
			File dir = new File(tempPath);
			if(!dir.exists()) {
				dir.mkdirs();
			}
		}
	}
	
}
