package com.ajashop.web.common.page;

/**
 * First Editor : dereklee
 * Last Editor  : dereklee
 * Date         : 2017-07-30
 * Description  :
 * Copyright ⓒ 2013-2015 dereklee All rights reserved.
 * version      : v0.1
 */

public class Pagination {
	int pageNum;
	int listSize;
	int listItemSize;
	int totalItemSize;
	
	public Pagination(int pageNum, int listSize) {
		this.pageNum = pageNum;
		this.listSize = listSize;
	}
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getListSize() {
		return listSize;
	}
	public void setListSize(int listSize) {
		this.listSize = listSize;
	}
	public int getListItemSize() {
		return listItemSize;
	}
	public void setListItemSize(int listItemSize) {
		this.listItemSize = listItemSize;
	}
	public int getTotalItemSize() {
		return totalItemSize;
	}
	public void setTotalItemSize(int totalItemSize) {
		this.totalItemSize = totalItemSize;
	}
	
	
}
