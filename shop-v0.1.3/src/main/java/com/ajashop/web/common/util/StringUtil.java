package com.ajashop.web.common.util;

/**
 * First Editor : dereklee
 * Last Editor  : dereklee
 * Date         : 2017-07-30
 * Description  :
 * Copyright ⓒ 2013-2015 dereklee All rights reserved.
 * version      : v0.1
 */

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;

public class StringUtil {
	public static final String PRE = "PRE";
	public static final String POST = "POST";

//	public static String getSizeString(int a, int size) {
//		return getSizeString(a, size, "0");
//	}
//
//	public static String getSizeString(long a, int size) {
//		return getSizeString(a, size, "0");
//	}

//	public static String getSizeString(int a, int size, String preFix) {
//		StringBuffer rvalue = new StringBuffer();
//
//		for (double i = Math.pow(10, (size - 1)); i >= 1; i = i / 10) {
//			if (a < i) {
//				rvalue.append(preFix);
//			}
//			else {
//				rvalue.append(a);
//				break;
//			}
//
//		}
//		return rvalue.toString();
//	}

//	public static String getSizeString(long a, int size, String preFix) {
//		StringBuffer rvalue = new StringBuffer();
//
//		for (double i = Math.pow(10, (size - 1)); i >= 1; i = i / 10) {
//			if (a < i) {
//				rvalue.append(preFix);
//			}
//			else {
//				rvalue.append(a);
//				break;
//			}
//		}
//		return rvalue.toString();
//	}

	public static byte[] getSizeString(byte[] a, int size, String preFix, String preflg) {
		byte[] rvalue = new byte[size];
		int index = 0;
		//byte[] tmp = a.getBytes();

		if (PRE.equals(preflg)) {
			for (int s = size; s > a.length; s--) {
				System.arraycopy(preFix.getBytes(), 0, rvalue, index, 1);
				index++;
			}
			System.arraycopy(a, 0, rvalue, index, a.length);
		}
		else {
			System.arraycopy(a, 0, rvalue, index, a.length);
			index += a.length;

			for (int s = size; s > a.length; s--) {
				System.arraycopy(preFix.getBytes(), 0, rvalue, index, 1);
				index++;
			}
		}

		return rvalue;
	}

//	public static String getNextNumString(String a) {
//		int num = Integer.parseInt(a);
//		num++;
//		return getSizeString(num, a.length());
//	}

	public static String getSizeString(String a, int size) {
		return getSizeString(a, size, "0", "PRE");
	}

	public static String getSizeString(String a, int size, String preFix, String preflg) {
		StringBuffer rvalue = new StringBuffer();
		byte[] tmp = a.getBytes();
		if ("PRE".equals(preflg)) {
			for (int s = size; s > tmp.length; s--) {
				rvalue.append(preFix);
			}
			rvalue.append(a);
		}
		else {
			rvalue.append(a);
			for (int s = size; s > tmp.length; s--) {
				rvalue.append(preFix);
			}
		}

		return rvalue.toString();
	}

//	public static String makeMethodName(String FieldName) {
//		String methodName = new String();
//		String[] token = FieldName.toLowerCase().split("_");
//
//		//methodName = token[0];
//		for (int i = 0; i < token.length; i++) {
//			methodName += (token[i].substring(0, 1).toUpperCase() + token[i].substring(1));
//		}
//		return methodName;
//	}

	
	public static String getConvertFieldName(String orderByType){
		int i=0, byLen = orderByType.length();
		String ss = "", rtString = "";
		for ( i=0;i<byLen;i++) {
			ss = orderByType.substring(i,i+1);
			if ( ss == ss.toUpperCase() && ss != ss.toLowerCase()) {
				rtString = rtString + "_" + ss;
			} else {
				rtString = rtString + ss;	
			}
		}
		return rtString.toUpperCase();
	}
		

	public static String[] splitString(String str, String token){
		StringTokenizer tokenizer;
		String[] arrRtn = null;
		int cnt, idx;
		if(null != str){
			tokenizer = new StringTokenizer(str, token);
			cnt = tokenizer.countTokens();
			arrRtn = new String[cnt];
	        idx = 0;
	        while(tokenizer.hasMoreElements()){
				arrRtn[idx++] = tokenizer.nextToken().trim();
	        }
		}
		return arrRtn;
	}
	
	public static List<String> splitList(String str, String token){
		StringTokenizer tokenizer;
		List<String> list = new ArrayList<>();
		
		if(null != str){
			tokenizer = new StringTokenizer(str, token);
	        while(tokenizer.hasMoreElements()){
	        	list.add(tokenizer.nextToken().trim());
	        }
		}
		return list;
	}
	
	public static String[] parseString(String str, String token) {
		ArrayList<String> arrStr = new ArrayList<String>();
		int startIdx = 0;
		int endIdx = 0;
		if (null != str) {
			while (true) {
				endIdx = str.indexOf(token, startIdx);

				if (endIdx == -1) {
					if (str.lastIndexOf(token) == str.length() - 1) {
						arrStr.add("");
					} else {
						arrStr.add(str.substring(startIdx));
					}
					break;
				}
				arrStr.add(str.substring(startIdx, endIdx));
				startIdx = endIdx + 1;
			}
		}
		return (String[]) arrStr.toArray(new String[arrStr.size()]);
	}
	
	public static byte[] hexstr2ascii(String src, int len) {
		int i = 0;

		byte[] ret = new byte[len / 2];
		String temp = new String();

		for (i = 0; i < len / 2; i++) {
			temp = src.substring(i * 2, i * 2 + 1);
			temp += src.substring(i * 2 + 1, i * 2 + 2);
			ret[i] = (byte) Integer.parseInt(temp, 16);
			temp = null;
		}

		return ret;
	}

	/**
	 * <P>
	 *
	 * </p>
	 * @param ascii
	 * @return
	 */
	public static String ascii2hexstr(byte[] ascii) {
		String ret = new String();
		//System.out.println("ascii.length : "+ascii.length);
		int i = 0;

		for (i = 0; i < ascii.length; i++) {
			ret += printHex(ascii[i]);
		}
		return ret;
	}

	/**
	 * <P>
	 *
	 * </p>
	 * @param data
	 * @return
	 */
	public static String printHex(byte data) {
		String ret = new String();
		String temp = new String();

		temp = Integer.toHexString((int) data);
		if (temp.length() == 2) {
			return temp;
		}
		if (temp.length() < 2) {
			ret = "0" + temp;
			return ret;
		}
		if (temp.length() > 2) {
			ret = temp.substring(temp.length() - 2, temp.length());
		}
		return ret;
	}

	/**
	 * <P>
	 *
	 * </p>
	 * @param english
	 * @return
	 */
	public static String E2K(String english) {
		String korean = null;

		if (english == null)
			return null;
		//if (english == null ) return "";

		try {
			korean = new String(english.getBytes("8859_1"), "KSC5601");
		}
		catch (UnsupportedEncodingException e) {
			korean = new String(english);
		}
		return korean;
	}

	/**
	 * <P>
	 *
	 * </p>
	 * @param korean
	 * @return
	 */
	public static String K2E(String korean) {
		String english = null;

		if (korean == null)
			return null;
		//if (korean == null ) return "";

		english = new String(korean);
		try {
			english = new String(korean.getBytes("KSC5601"), "8859_1");
		}
		catch (UnsupportedEncodingException e) {
			english = new String(korean);
		}
		return english;
	}

//	/**
//	 * <P>
//	 *
//	 * </p>
//	 * @param strDate
//	 * @param format
//	 * @return
//	 * @throws ParseException
//	 */
//	public static Date getDate(String strDate, String format) throws ParseException {
//		SimpleDateFormat formatter = new java.text.SimpleDateFormat(format, java.util.Locale.KOREA);
//		Date date = formatter.parse(strDate);
//		return date;
//	}

	/**
	 * <P>
	 *
	 * </p>
	 * @param date
	 * @return
	 */
	public static java.sql.Date getSqlDate(Date date) {
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		return sqlDate;
	}

	public static String cutString(String str, int size) {
		String result = null;
		try {
			if (str == null || size == 0) {
				result = "";
			}
			else {
				String subKor = null;
				String resultKor = null;
				String kscKor = null;
				//subKor = str.substring(0,size);
				byte[] tmp = str.getBytes();
				if (tmp.length <= size) {
					result = str;
				}
				else {

					byte[] tt = new byte[size];
					for (int i = 0; i < size; i++)
						tt[i] = tmp[i];

					subKor = new String(tt);
					try {
						kscKor = new String(subKor.getBytes("8859_1"), "euc-kr");
					}
					catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					try {
						resultKor = new String(kscKor.getBytes("euc-kr"), "8859_1");
					}
					catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					if (resultKor == null) {
						resultKor = subKor;
					}
					if (resultKor.equals(""))
						subKor = str.substring(0, size - 1);

					result = subKor + "...";
				}
			}
		}
		catch (IndexOutOfBoundsException e) {
			result = str;
		}
		return result;
	}

	public static boolean isNull(String value) {
		if (value == null || value.trim().equals(""))
			return true;

		return false;
	}

	public static String replaceNull(String value) {
		return replaceNull(value, "");
	}

	public static String replaceNull(String value, String repStr) {
		if (isNull(value))
			return repStr;

		return value.trim();
	}

	public static int parseInt(String value) {
		int rvalue = 0;
		if (value == null || "".equals(value)) {
			rvalue = 0;
		}
		else {
			try{
				rvalue = Integer.parseInt(value);
			}catch(Exception e){
				rvalue = 0;
			}
		}
		return rvalue;
	}
	
	public static long parseLong(String value) {
		long rvalue = 0;
		if (value == null || "".equals(value)) {
			rvalue = 0;
		}
		else {
			try{
				rvalue = Long.parseLong(value);
			}catch(Exception e){
				rvalue = 0;
			}
		}
		return rvalue;
	}

//	public static String ReplaceAll(String buffer, String src, String dst)
//	{
//		if (buffer == null)
//			return null;
//		if (src == null || buffer.indexOf(src) < 0)
//			return buffer;
//
//		int bufLen = buffer.length();
//		int srcLen = src.length();
//		StringBuffer result = new StringBuffer();
//
//		int i = 0;
//		int j = 0;
//		for (; i < bufLen;)
//		{
//			j = buffer.indexOf(src, j);
//			if (j >= 0)
//			{
//				result.append(buffer.substring(i, j));
//				result.append(dst);
//
//				j += srcLen;
//				i = j;
//			}
//			else
//				break;
//		}
//		result.append(buffer.substring(i));
//		return result.toString();
//	}

	public static int getLength(String str) {
		return str.getBytes().length;
	}
	
	
//	public static String getSubstring(String str, int start, int end, boolean bl) {
//		if (null == str) {
//			return null;
//		}
//
//		int srcLen = getLength(str);
//		if (srcLen <= start) {
//			return str;
//		}
//
//		char chr;
//		int sIdx = 0;
//		int eIdx = 0;
//		int readLen = 0;
//
//		String readStr = str;
//		try {
//			
//			for (sIdx = 0; sIdx < start && readLen < start; sIdx++) {
//				chr = str.charAt(sIdx);
//				if (0 == (chr & 0xFF00)) {
//					readLen++;
//				} else {
//					readLen += 2;
//				}
//			}
//	
//			readLen = 0;
//			for (eIdx = 0; eIdx < end && readLen < end && readLen < srcLen; eIdx++) {
//				chr = str.charAt(eIdx);
//				if (0 == (chr & 0xFF00)) {
//					readLen++;
//				} else {
//					readLen += 2;
//				}
//			}
//			if (end < readLen) {
//				eIdx--;
//			}
//			readStr = str.substring(sIdx, eIdx);
//
//		}catch (Exception e) {
//			
//		}
//		if ( srcLen > readLen ) {
//			readStr = readStr + "...";
//		}
//		return readStr;
//	}
	
	
    public static String getLeftPadding(String src, String pad, int size) {
            StringBuffer sb = new StringBuffer(10);
            if (null == src) {
                    return null;
            }
            for (int i = 0; i < size - src.length(); i++) {
                    sb.append(pad);
            }
            sb.append(src);
            return sb.toString();
    }
    
	
    /**
	 * 
	 * @param format
	 * 			ex> format : yyyyMMddHHmmssSSS
	 * @return
	 */
	public static String getCurrentTime(String format) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);

		return dateFormat.format(calendar.getTime());
	}
	
	
	public synchronized static String getCurrentTimeString() {
			
		String currentTimeString = new String();
		int tempint = 0;
		String tempString = new String();

		Calendar calendar = Calendar.getInstance();

		currentTimeString += calendar.get(Calendar.YEAR);		
		
		tempint = calendar.get(Calendar.MONTH) + 1;
		tempString = int2ZeroFillString(tempint, 2);
		currentTimeString += tempString;
		
		tempint = calendar.get(Calendar.DAY_OF_MONTH);
		tempString = int2ZeroFillString(tempint, 2);
		currentTimeString += tempString;
						
		tempint = calendar.get(Calendar.HOUR_OF_DAY);
		tempString = int2ZeroFillString(tempint, 2);
		currentTimeString += tempString;
		
		tempint = calendar.get(Calendar.MINUTE);
		tempString = int2ZeroFillString(tempint, 2);
		currentTimeString += tempString;
		
		tempint = calendar.get(Calendar.SECOND);
		tempString = int2ZeroFillString(tempint, 2);
		currentTimeString += tempString;

//		currentTimeString += calendar.get(13);
		tempint = calendar.get(Calendar.MILLISECOND);
		tempString = int2ZeroFillString(tempint, 3);
		currentTimeString += tempString;
		
		calendar = null;

		return currentTimeString;
	}
	
	public static String int2ZeroFillString(int value, int length) {
		String returnString = new String();
		String valueString = new String();
		Integer m_Integer;
		int i = 0;

		m_Integer = new Integer(value);
		valueString = m_Integer.toString();
		if (valueString.length() > length) {
			return null;
		}

		if (valueString.length() == length) {
			return valueString;
		}

		for (i = 0; i < length - valueString.length(); i++) {
			returnString += "0";
		}

		returnString += valueString;
		return returnString;
	}
	
	public static String long2ZeroFillString(long value, int length) {
		String returnString = new String();
		String valueString = new String();
		Long m_Long;
		int i = 0;

		m_Long = new Long(value);
		valueString = m_Long.toString();
		if (valueString.length() > length) {
			return null;
		}

		if (valueString.length() == length) {
			return valueString;
		}

		for (i = 0; i < length - valueString.length(); i++) {
			returnString += "0";
		}

		returnString += valueString;
		return returnString;
	}
	
	
	
	public static String cutFirstStrInByte(String str, int endIndex) {
		StringBuffer sbStr = new StringBuffer(endIndex);
		int iTotal=0;
		for(char c: str.toCharArray()) {
			iTotal+=String.valueOf(c).getBytes().length;
			if(iTotal>endIndex) break;
			sbStr.append(c);
		}
		return sbStr.toString();
	}
	
	public static String aaaaa(String korean) {
		String english = null;

		if (korean == null)
			return null;
		//if (korean == null ) return "";

		english = new String(korean);
		try {
			english = new String(korean.getBytes("UTF-8"), "UTF-8");
		}
		catch (UnsupportedEncodingException e) {
			english = new String(korean);
		}
		return english;
	}
	
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
	
//	public static void main(String[] args) {
////			String src = "3016000c70622f6b656570616c697665";
////			
////			System.out.println(new String(StringUtil.hexstr2ascii(src, src.length())));
//	
//		System.out.println(StringUtil.phoneFormat("01096420688"));
//	
//	}
	public static void main(String[] args) {
		System.out.println("1025.12".replaceAll("\\.", ""));
	}
}
