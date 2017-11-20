package com.ajashop.web.common.page;


import net.sf.json.JSONObject;
import static com.ajashop.web.common.constants.PaginationConstants.*;
import com.ajashop.web.common.constants.PaginationConstants;

/**
 * First Editor : dereklee
 * Last Editor  : dereklee
 * Date         : 2017-07-30
 * Description  :
 * Copyright ⓒ 2013-2015 dereklee All rights reserved.
 * version      : v0.1
 */

public class PagingUtil {
	
	public static String pagination(int pageNum, int totalSearchCount ) {
		return PagingUtil.pagination(pageNum, PaginationConstants.DEFAULT_LIST_SIZE, totalSearchCount);
	}
	
	public static String pagination(int pageNum, int listSize, int totalSearchCount ) {
		Paging resultPagingInfo = new Paging();
		
		int blockSize = PAGING_BLOCK_SIZE;
		resultPagingInfo.setBlockSize(blockSize);
		
		if(totalSearchCount <= 0)	totalSearchCount = DEFAULT_PAGE_TOTAL_SEARCH_COUNT;
		resultPagingInfo.setTotalSearchCount(totalSearchCount);
		
		if(listSize <= 0)	listSize = DEFAULT_LIST_SIZE;
		
		if(pageNum <= 0)	pageNum = DEFAULT_PAGE_NUM;
		resultPagingInfo.setNowPage(pageNum);
		
//		int pageCount = (int)Math.ceil((double)totalSearchCount/listSize);
		int pageCount = ((totalSearchCount-1)/listSize)+1;
		resultPagingInfo.setPageCount(pageCount);
		
		int startPage = ((pageNum - 1) / blockSize) * blockSize + 1;
		resultPagingInfo.setStartPage(startPage);
		
		int endPage = startPage + blockSize - 1;
		if (endPage > pageCount) endPage = pageCount;
		resultPagingInfo.setEndPage(endPage);
		
		int prevPage = startPage -1;
		resultPagingInfo.setPrevPage(prevPage);
		
		int nextPage = endPage + 1;
		resultPagingInfo.setNextPage(nextPage);
		
		int totalPage = ((totalSearchCount-1)/listSize)+1;
		resultPagingInfo.setTotalPage(totalPage);
		
		int prevBlock = (int)Math.floor((pageNum-1)/blockSize)*blockSize;
		resultPagingInfo.setPrevBlock(prevPage);
		
		int nextBlock = prevBlock + blockSize +1;
		resultPagingInfo.setNextBlock(nextPage);
		
		int startNoPerPage = totalSearchCount-listSize*(pageNum-1);
		resultPagingInfo.setStartNoPerPage(startNoPerPage);
		
		return JSONObject.fromObject(resultPagingInfo).toString();
	}
}
