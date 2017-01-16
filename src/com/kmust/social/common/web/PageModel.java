package com.kmust.social.common.web;

/**
 * 分页实体
 * @author Administrator
 * @date 2016年8月16日 下午8:13:53 
 * @version V1.0
 */
public class PageModel {
	/** 定义默认每页显示的记录条数常量 */
	private final static int PAGE_SIZE = 2;
	/** 当前页码 */
	private int pageIndex;
	/** 每页显示的记录条数 */
	private int pageSize;
	/** 总记录条数 */
	private int recordCount;
	
	/** setter and getter method */
	public int getPageIndex() {
		/** 计算总页数 */
		int totalPage = (recordCount - 1) / getPageSize() + 1;
		/** 当前页码不能小于1 */
		pageIndex = (pageIndex <= 1 ? 1 : pageIndex);
		/** 当前页码不能大于总页数 */
		return pageIndex > totalPage ? totalPage : pageIndex;
		
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return pageSize <= 0 ? PAGE_SIZE : pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	/** 分页的起始行 */
	public int getStartRow(){
		return (getPageIndex() - 1) * getPageSize();
	}
}