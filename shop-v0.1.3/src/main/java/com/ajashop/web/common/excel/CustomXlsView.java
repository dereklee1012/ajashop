package com.ajashop.web.common.excel;

import java.net.URLEncoder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.web.servlet.view.document.AbstractExcelView;

/**
 * First Editor : dereklee
 * Last Editor  : dereklee
 * Date         : 2017-07-30
 * Description  :
 * Copyright ⓒ 2013-2015 dereklee All rights reserved.
 * version      : v0.1
 */

public class CustomXlsView extends AbstractExcelView  {

//	@Override
//	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
	/*
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workBook, HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<HashMap<String, Object>> excelBodys = (List<HashMap<String, Object>>) model.get("excelBodys");
		String sheetName = model.get("sheetName").toString();
		Sheet sheet = workBook.createSheet(sheetName);
        sheet.setDefaultColumnWidth(15);
        
        CellStyle style = workBook.createCellStyle();
        Font font = workBook.createFont();
        font.setFontName("Arial");
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        style.setFont(font);
        
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        
        List<String> headerKeys = null;
        
        ExcelHeader excelHeader = (ExcelHeader) model.get("header");
    	Row header = sheet.createRow(0);
    	List<ExcelHeaderCell> excelHeaderCells = excelHeader.getHeaderCells();
    	for(int j = 0;j<excelHeaderCells.size();j++) {
    		ExcelHeaderCell excelHeaderCell = excelHeaderCells.get(j);
    		Cell cell = header.createCell(excelHeaderCell.getCellIndex());
    		cell.setCellValue(excelHeaderCell.getTitle());
    		
    		if(excelHeaderCell.getMergeSize() > 1) {
    			sheet.addMergedRegion(new CellRangeAddress(0, 0, excelHeaderCell.getCellIndex(), excelHeaderCell.getCellIndex() + excelHeaderCell.getMergeSize() - 1));        			
    		}
    		
    		if(excelHeader.isKey()) {
    			headerKeys = excelHeader.getHeaderKeys();
    		}
    		cell.setCellStyle(style);
    	}
        
        for(int i = 0;i<excelBodys.size();i++) {
        	Row aRow = sheet.createRow(1 + i);
        	
        	HashMap<String, Object> excelBody = excelBodys.get(i);
        	for(int j = 0;j<headerKeys.size();j++) {
        		Cell cell = aRow.createCell(j);
        		Object value = excelBody.get(headerKeys.get(j));
        		
        		if(value != null) {
        			cell.setCellValue(value.toString());
        		} else {
        			cell.setCellValue("");
        		}
        		cell.setCellStyle(style);
        	}
        }
        
        
        
        String httpHeaderr = getBrowser(request);
        if (httpHeaderr.contains("MSIE")) {
            String docName = URLEncoder.encode((sheetName + ".xls"),"UTF-8").replaceAll("\\+", "%20");
            response.setHeader("Content-Disposition", "attachment;filename=" + docName + ";");
	     } else if (httpHeaderr.contains("Firefox")) {
	            String docName = new String((sheetName + ".xls").getBytes("UTF-8"), "ISO-8859-1");
	            response.setHeader("Content-Disposition", "attachment; filename=\"" + docName + "\"");
	     } else if (httpHeaderr.contains("Opera")) {
	            String docName = new String((sheetName + ".xls").getBytes("UTF-8"), "ISO-8859-1");
	            response.setHeader("Content-Disposition", "attachment; filename=\"" + docName + "\"");
	     } else if (httpHeaderr.contains("Chrome")) {
	            String docName = new String((sheetName + ".xls").getBytes("UTF-8"), "ISO-8859-1");
	            response.setHeader("Content-Disposition", "attachment; filename=\"" + docName + "\"");
	     }
	}*/

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workBook, HttpServletRequest request,	HttpServletResponse response) throws Exception {
		List<HashMap<String, Object>> excelBodys = (List<HashMap<String, Object>>) model.get("excelBodys");
		String sheetName = model.get("sheetName").toString();
		Sheet sheet = workBook.createSheet(sheetName);
        sheet.setDefaultColumnWidth(15);
        
        CellStyle style = workBook.createCellStyle();
        Font font = workBook.createFont();
        font.setFontName("Arial");
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        style.setFont(font);
        
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        
        List<String> headerKeys = null;
        
        ExcelHeader excelHeader = (ExcelHeader) model.get("header");
    	Row header = sheet.createRow(0);
    	List<ExcelHeaderCell> excelHeaderCells = excelHeader.getHeaderCells();
    	for(int j = 0;j<excelHeaderCells.size();j++) {
    		ExcelHeaderCell excelHeaderCell = excelHeaderCells.get(j);
    		Cell cell = header.createCell(excelHeaderCell.getCellIndex());
    		cell.setCellValue(excelHeaderCell.getTitle());
    		
    		if(excelHeaderCell.getMergeSize() > 1) {
    			sheet.addMergedRegion(new CellRangeAddress(0, 0, excelHeaderCell.getCellIndex(), excelHeaderCell.getCellIndex() + excelHeaderCell.getMergeSize() - 1));        			
    		}
    		
    		if(excelHeader.isKey()) {
    			headerKeys = excelHeader.getHeaderKeys();
    		}
    		cell.setCellStyle(style);
    	}
        
        for(int i = 0;i<excelBodys.size();i++) {
        	Row aRow = sheet.createRow(1 + i);
        	
        	HashMap<String, Object> excelBody = excelBodys.get(i);
        	for(int j = 0;j<headerKeys.size();j++) {
        		Cell cell = aRow.createCell(j);
        		Object value = excelBody.get(headerKeys.get(j));
        		
        		if(value != null) {
        			cell.setCellValue(value.toString());
        		} else {
        			cell.setCellValue("");
        		}
        		cell.setCellStyle(style);
        	}
        }
        
        
        
        String httpHeaderr = getBrowser(request);
        if (httpHeaderr.contains("MSIE")) {
            String docName = URLEncoder.encode((sheetName + ".xls"),"UTF-8").replaceAll("\\+", "%20");
            response.setHeader("Content-Disposition", "attachment;filename=" + docName + ";");
	     } else if (httpHeaderr.contains("Firefox")) {
	            String docName = new String((sheetName + ".xls").getBytes("UTF-8"), "ISO-8859-1");
	            response.setHeader("Content-Disposition", "attachment; filename=\"" + docName + "\"");
	     } else if (httpHeaderr.contains("Opera")) {
	            String docName = new String((sheetName + ".xls").getBytes("UTF-8"), "ISO-8859-1");
	            response.setHeader("Content-Disposition", "attachment; filename=\"" + docName + "\"");
	     } else if (httpHeaderr.contains("Chrome")) {
	            String docName = new String((sheetName + ".xls").getBytes("UTF-8"), "ISO-8859-1");
	            response.setHeader("Content-Disposition", "attachment; filename=\"" + docName + "\"");
	     }
	}
	
	private String getBrowser(HttpServletRequest request) {
        String header =request.getHeader("User-Agent");
        if (header.contains("MSIE")) {
               return "MSIE";
        } else if(header.contains("Chrome")) {
               return "Chrome";
        } else if(header.contains("Opera")) {
               return "Opera";
        }
        return "Firefox";
	}
	
}
