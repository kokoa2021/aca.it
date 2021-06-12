package com.kokoa.acait.vo;

public class CriteriaVO extends rateVO{
    /* 현재 페이지 */
    private int pageNum;
    
    /* 한 페이지 당 보여질 게시물 갯수 */
    private int amount;
    
    /* 스킵 할 게시물 수( (pageNum-1) * amount ) */
    private int skip;
    
    /* 정렬 방식 */
    private String sort;
    
    /* 기본 생성자 -> 기봅 세팅 : pageNum = 1, amount = 10 */
    public CriteriaVO() {
        this(1,10);
        this.setSkip(0);
    }
    
    /* 생성자 => 원하는 pageNum, 원하는 amount */
    public CriteriaVO(int pageNum, int amount) {
        this.setPageNum(pageNum);
        this.setAmount(amount);
        this.setSkip((pageNum-1)*amount);
    }

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
		this.skip = (pageNum-1)*this.amount;
	}

	public int getAmount() {
		this.skip = (this.pageNum-1)*amount;
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getSkip() {
		return skip;
	}

	public void setSkip(int skip) {
		this.skip = skip;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	@Override
	public String toString() {
		return "CriteriaVO [pageNum=" + pageNum + ", amount=" + amount + ", skip=" + skip + ", sort=" + sort + "]";
	}
}