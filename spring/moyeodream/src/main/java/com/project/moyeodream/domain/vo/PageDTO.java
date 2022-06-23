package com.project.moyeodream.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class PageDTO {
    private Integer startPage; /* 시작되는 페이지 번호 ex) 1, 11, 21, 31,,,, */
    private Integer endPage; /* 끝나는 페이지 번호  ex) 10, 20, 30, 40 ,,, */
    private Integer realEnd;
    private boolean next, prev;
    private Integer total;
    private Criteria criteria;

    public PageDTO(Criteria criteria, Integer total) {
        this.criteria = criteria;
        this.total = total;
        this.endPage = (int) (Math.ceil(criteria.getPageNum() / (double) criteria.getAmount())) * criteria.getAmount();
        this.startPage = endPage - 9;
        this.realEnd = (int) (Math.ceil(total / (double) criteria.getAmount()));

        if (realEnd < this.endPage) {
            this.endPage = realEnd;
        }

        this.prev = this.startPage > 1;
        this.next = this.endPage < realEnd;
    }
}
