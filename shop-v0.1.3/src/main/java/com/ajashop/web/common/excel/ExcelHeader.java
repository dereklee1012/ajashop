package com.ajashop.web.common.excel;


import java.util.List;

/**
 * First Editor : dereklee
 * Last Editor  : dereklee
 * Date         : 2017-07-30
 * Description  :
 * Copyright ⓒ 2013-2015 dereklee All rights reserved.
 * version      : v0.1
 */

public class ExcelHeader {

	boolean isKey;
	List<String> headerKeys;
	List<ExcelHeaderCell> headerCells;

	public List<String> getHeaderKeys() {
		return headerKeys;
	}

	public void setHeaderKeys(List<String> headerKeys) {
		this.headerKeys = headerKeys;
	}

	public List<ExcelHeaderCell> getHeaderCells() {
		return headerCells;
	}

	public void setHeaderCells(List<ExcelHeaderCell> headerCells) {
		this.headerCells = headerCells;
	}
	public boolean isKey() {
		return isKey;
	}

	public void setKey(boolean isKey) {
		this.isKey = isKey;
	}
	
}
