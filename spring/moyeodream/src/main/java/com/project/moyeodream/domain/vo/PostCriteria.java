package com.project.moyeodream.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@Data
@AllArgsConstructor
public class PostCriteria extends Criteria {

    private Integer pageNum;        // 현재 페이지
    private Integer amount;         // 한 페이지당 출력되는 데이터 개수
    private String type;            // 검색필터 > 검색기준
    private String keyword;         // 검색필터 > 검색어

    public PostCriteria(){
        this(1,5);
    }

    public PostCriteria(Integer pageNum, Integer amount){
        super();
        this.pageNum = pageNum;
        this.amount = amount;
    }

    public String getListLink() {
        UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
                .queryParam("pageNum", this.pageNum)
                .queryParam("amount", this.amount)
                .queryParam("type", this.type)
                .queryParam("keyword", this.keyword);

        return builder.toUriString();
    }
}
