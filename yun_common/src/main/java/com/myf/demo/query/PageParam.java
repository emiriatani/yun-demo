package com.myf.demo.query;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @ClassName com.myf.demo.query PageParam
 * @Description
 * @Author Afengis
 * @Date 2021/4/25 9:42
 * @Version V1.0
 **/

@NoArgsConstructor
@AllArgsConstructor
public class PageParam {

    /*页码*/
    private int  pageIndex = 1;
    /*每页大小*/
    private int pageSize = 10;
    /*排序字段*/
    private String sortField;
    /*排序方式*/
    private String sortOrder;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Override
    public String toString() {
        return "PageParam{" +
                "pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", sortField='" + sortField + '\'' +
                ", sortOrder='" + sortOrder + '\'' +
                '}';
    }
}
