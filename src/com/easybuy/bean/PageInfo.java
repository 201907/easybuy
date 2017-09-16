package com.easybuy.bean;

public class PageInfo<T>{
	//总共的页数
	private int pageCount;
	//当前的页码数
	private int nowPage;
	//上一页
	private int prevPage;
	//下一页
	private int nextPage;
	//是否成功
	private boolean success;

	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public T getItem() {
		return item;
	}
	public void setItem(T item) {
		this.item = item;
	}
	//内容
	private T item;
	private PageInfo(int pageCount,int nowPage, T item) {
		super();
		this.prevPage = nowPage-1;
		this.nextPage = nowPage+1;
		//判断是否正确页码数什么的是否正确并进行修正
		if(nowPage>=pageCount) {
			nowPage = pageCount;
			this.nextPage = pageCount;
		}
		if(nowPage<=1) {
			nowPage = 1;
			this.prevPage = 1;
		}
		this.pageCount = pageCount;
		this.nowPage = nowPage;
		this.item = item;
	}
	/**
	 * 上一页
	 * @return
	 */
	public PageInfo<T> getPrevPage(){
		return valueOfPageInfo(pageCount,nowPage-1,item);
	}
	/**
	 * 上一页
	 * @return
	 */
	public PageInfo<T> getNextPage(){
		return valueOfPageInfo(pageCount,nowPage+1,item);
	}
	/**
	 * 静态构造
	 * @param count
	 * @param nowPage
	 * @param t
	 * @return
	 */
	public static<T> PageInfo valueOfPageInfo(int count,int nowPage,T t){
		return new PageInfo(count,nowPage,t);
	}
}
