package pl.pogos.tododays.dto;

import java.io.Serializable;

public class PagingDTO implements Serializable {
    private int page;
    private int pageSize;
    private int pageNumber;
    private long recordNumber;

    public PagingDTO() {
    }

    public PagingDTO(int page, int pageSize, int pageNumber, long recordNumber) {
        this.page = page;
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.recordNumber = recordNumber;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
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

    public long getRecordNumber() {
        return recordNumber;
    }

    public void setRecordNumber(long recordNumber) {
        this.recordNumber = recordNumber;
    }
}
