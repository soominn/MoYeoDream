package com.project.moyeodream.mapper;

import com.project.moyeodream.domain.vo.FileVO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileMapper {
    // 게시판 - 파일 등록
    public void insertPost(FileVO fileVO);

}
