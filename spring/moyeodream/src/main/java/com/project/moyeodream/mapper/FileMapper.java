package com.project.moyeodream.mapper;

import com.project.moyeodream.domain.vo.FileVO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileMapper {
    // 게시판 - 파일 등록
    public void insertPost(FileVO fileVO);

    // 게시판 - 파일 가져오기
    public List<FileVO> selectPost(Integer postNumber);

    // 게시판 - 파일 삭제
    public void deletePost(Integer postNumber);
}
