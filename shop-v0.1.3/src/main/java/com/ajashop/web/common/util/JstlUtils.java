package com.ajashop.web.common.util;

/**
 * First Editor : dereklee
 * Last Editor  : dereklee
 * Date         : 2017-07-30
 * Description  :
 * Copyright ⓒ 2013-2015 dereklee All rights reserved.
 * version      : v0.1
 */

import java.util.List;

import org.apache.commons.lang.StringUtils;

public class JstlUtils {
	static final String imageUrlPrefix = "http://211.232.21.41/freemarket-contents";
	public static String phoneFormat(String phoneNo){
		if(StringUtils.isEmpty(phoneNo)) return "-";
		
		if (phoneNo.length() == 0){
			return phoneNo;
		}
		   
		String strTel = phoneNo;
		String[] strDDD = {"02" , "031", "032", "033", "041", "042", "043",
	                   "051", "052", "053", "054", "055", "061", "062",
	                   "063", "064", "010", "011", "012", "013", "015",
	                   "016", "017", "018", "019", "070"};
	  
		if (strTel.length() < 9) {
			return strTel;
		} else if (strTel.substring(0,2).equals(strDDD[0])) {
			strTel = strTel.substring(0,2) + '-' + strTel.substring(2, strTel.length()-4) + '-' + strTel.substring(strTel.length() -4, strTel.length());
		} else {
			for(int i=1; i < strDDD.length; i++) {
				if (strTel.substring(0,3).equals(strDDD[i])) {
					strTel = strTel.substring(0,3) + '-' + strTel.substring(3, strTel.length()-4) + '-' + strTel.substring(strTel.length() -4, strTel.length());
				}
			}
		}
		
		return strTel;
	}
	
	public static String makeProductThumbnailUrl(String prodUserId, String prodId, String imageName) {
		String groupId = makeGroupId(Long.parseLong(prodUserId));
		String productImageFilePath = makeProductThumbImageFilePath(groupId, Long.parseLong(prodUserId), Integer.parseInt(prodId), imageName);
		return makeImageUrl(productImageFilePath);
	}
	
	public static String makeProductUrl(String prodUserId, String prodId, String imageName) {
		String groupId = makeGroupId(Long.parseLong(prodUserId));
		String productImageFilePath = makeProductImageFilePath(groupId, Long.parseLong(prodUserId), Integer.parseInt(prodId), imageName);
		return makeImageUrl(productImageFilePath);
	}
	
	public static List<String> getImages(String images) {
		return StringUtil.splitList(images, ",");
	}
	
	private static String makeProductThumbImageFilePath(String groupId, long prodUserId, int prodId, String imageName) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("/");
		buffer.append(groupId);
		buffer.append("/");
		buffer.append(prodUserId);
		buffer.append("/");
		buffer.append(prodId);
		buffer.append("/");
		buffer.append("thumb/");
		buffer.append(imageName);
		return buffer.toString();
	}
	private static String makeProductImageFilePath(String groupId, long prodUserId, int prodId, String imageName) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("/");
		buffer.append(groupId);
		buffer.append("/");
		buffer.append(prodUserId);
		buffer.append("/");
		buffer.append(prodId);
		buffer.append("/");
		buffer.append(imageName);
		return buffer.toString();
	}
	
	private static String makeImageUrl(String filePath) {
		return imageUrlPrefix + filePath;
	}
	
	private static String makeGroupId(long prodUserId) {
		return Long.toString(prodUserId / 1000);
	}
	
	public static void main(String[] args) {
		
		System.out.println(JstlUtils.phoneFormat("01096420600"));
	}
	
	public static double distance(double sLat, double sLng, double tLat, double tLng) {
		return (
			Math.acos(
				Math.sin(sLat*Math.PI / 180.0) *
				Math.sin(tLat*Math.PI / 180.0) +
				Math.cos(sLat*Math.PI / 180.0) *
				Math.cos(tLat*Math.PI / 180.0) *
				Math.cos((sLng-tLng)*Math.PI/180.0)
			) * 180.0 / Math.PI
		) * 60*1.1515*1.609344*1000;
	}
	
	public static String distanceString(String sLat, String sLng, String tLat, String tLng) {
		Double distance = distance(Double.parseDouble(sLat), Double.parseDouble(sLng), Double.parseDouble(tLat), Double.parseDouble(tLng));
		if(distance >= 1000) {
			return distance.intValue() + "KM";
		} else {
			return distance.intValue() + "M";
		}
	}
}
