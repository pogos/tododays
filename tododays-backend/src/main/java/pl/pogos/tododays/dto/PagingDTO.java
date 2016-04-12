package pl.pogos.tododays.dto;

import java.io.Serializable;

/**
 * Created by SG0952928 on 2016-04-12.
 */
public class PagingDTO implements Serializable {
    private int startPage;
    private int pageSize;
    private int pageNumber;
    private int recordNumber;

    public PagingDTO() {
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getRecordNumber() {
        return recordNumber;
    }

    public void setRecordNumber(int recordNumber) {
        this.recordNumber = recordNumber;
    }
}
