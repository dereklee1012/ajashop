package com.ajashop.web.common.util;

/**
 * First Editor : dereklee
 * Last Editor  : dereklee
 * Date         : 2017-07-17
 * Description  :
 * Copyright ⓒ 2013-2015 dereklee All rights reserved.
 * version      : v0.1
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;


@Component(value="fileDownloadView")
public class FiledownUtil extends AbstractView{

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		File file = (File)model.get("filedown");
		res.setContentType("application/download; utf-8");
		res.setContentLength((int) file.length());//error nullpointexception 
		 
		String userAgent = req.getHeader("User-Agent");
		String rename = (String) req.getAttribute("fileName");
		String fileName = rename == null ? file.getName() : rename;
		 
		if (userAgent.indexOf("MSIE") > -1 || userAgent.indexOf("Trident") > -1) {   // MS IE 브라우저에서 한글 인코딩
			res.setHeader("Content-Disposition", "attachment; filename="
		     + java.net.URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "\\ ") + ";");
		} else {                                                                                              // 모질라나 오페라 브라우저에서 한글 인코딩​
			res.setHeader("Content-Disposition",
		     "attachment; filename=" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1").replaceAll("\\+", "\\ ") + ";");
		}
		  
		res.setHeader("Content-Transfer-Encoding", "binary");
		OutputStream out = res.getOutputStream();
		FileInputStream fis = null;
		try {
		   fis = new FileInputStream(file);
		   FileCopyUtils.copy(fis, out);
		} catch (Exception e) {
		   e.printStackTrace();
		} finally {
		   if (fis != null) {
			   try {
				   fis.close();
			   } catch (Exception e) {
			   }
		   }
		}
		out.flush();
	}
}
