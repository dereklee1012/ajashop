package com.ajashop.web.common.excel;

/**
 * First Editor : dereklee
 * Last Editor  : dereklee
 * Date         : 2017-07-30
 * Description  :
 * Copyright ⓒ 2013-2015 dereklee All rights reserved.
 * version      : v0.1
 */

public class ExcelHeaderCell {

	int cellIndex;
	int mergeSize;
	String title;
	public int getCellIndex() {
		return cellIndex;
	}
	public void setCellIndex(int cellIndex) {
		this.cellIndex = cellIndex;
	}
	public int getMergeSize() {
		return mergeSize;
	}
	public void setMergeSize(int mergeSize) {
		this.mergeSize = mergeSize;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
