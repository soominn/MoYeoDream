package com.project.moyeodream.domain.dao;

import com.project.moyeodream.domain.vo.FileVO;
import com.project.moyeodream.mapper.FileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FileDAO {
    private final FileMapper fileMapper;

    // 게시판 파일 등록
    public void save(FileVO fileVO){
        fileMapper.insertPost(fileVO);
    }
}
