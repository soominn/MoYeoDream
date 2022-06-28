package com.project.moyeodream.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@Slf4j
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

                                                            // criteria.getAmount (X)
        if(total != 0){                                     // 게시물 개수가 아닌 한페이지에 나올 페이지 넘버의 개수(10)를 곱해줌
            this.endPage = (int) (Math.ceil(criteria.getPageNum() / 10.0)) * 10;
        }else {
            this.endPage = 9;
        }

        this.startPage = endPage - 9;
        this.realEnd = (int) (Math.ceil(total / (double) criteria.getAmount()));

        if (realEnd < this.endPage) {
            this.endPage = realEnd;
        }

        this.prev = this.startPage > 1;
        this.next = this.endPage < realEnd;
    }

}
