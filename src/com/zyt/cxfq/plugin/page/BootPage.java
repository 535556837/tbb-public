package com.zyt.cxfq.plugin.page;

import java.io.Serializable;
import java.util.List;


public class BootPage<T> implements  Serializable{
    /**
     *数据索引从0开始
     */
    private Integer offset = Integer.valueOf(0);
    /**
     * 数据条数
     */
    private Integer limit = Integer.valueOf(10);
    private String sort;
    private String order;
    /**
     * 数据总条数
     */
    private int total;
    /**
     * 数据内容
     */
    private List<T> rows;

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getBegin() {
        return this.offset.intValue();
    }

    public int getEnd() {
        return this.offset.intValue() + this.limit.intValue();
    }

    public Integer getOffset() {
        return this.offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public List<T> getRows() {
        return this.rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public String getSort() {
        return this.sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return this.order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

	@Override
	public String toString() {
		return "BootPage [offset=" + offset + ", limit=" + limit + ", sort=" + sort + ", order=" + order + ", total="
				+ total + ", rows=" + rows + "]";
	}
    
    
    
    
    
}
