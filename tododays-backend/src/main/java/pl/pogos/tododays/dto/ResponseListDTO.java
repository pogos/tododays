package pl.pogos.tododays.dto;


import org.springframework.data.domain.Page;

import java.util.List;

public class ResponseListDTO<T> extends ResponseDTO {

    private List<T> data;
    private PagingDTO paging;

    public ResponseListDTO() {
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public PagingDTO getPaging() {
        return paging;
    }

    public void setPaging(PagingDTO paging) {
        this.paging = paging;
    }

    public void fillResponseList(Integer pageNumber, Integer size, Page page, List<T> data) {
        this.setPaging(new PagingDTO(pageNumber, size, page.getTotalPages(), page.getTotalElements()));
        this.setData(data);
    }
}
