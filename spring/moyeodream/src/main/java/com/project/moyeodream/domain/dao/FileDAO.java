package com.project.moyeodream.domain.dao;

import com.project.moyeodream.domain.vo.FileVO;
import com.project.moyeodream.mapper.FileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FileDAO {
    private final FileMapper fileMapper;

    // 게시판 - 파일 등록
    public void save(FileVO fileVO){
        fileMapper.insertPost(fileVO);
    }

    // 게시판 - 파일 가져오기
    public List<FileVO> getFileList(Integer postNumber){
        return fileMapper.selectPost(postNumber);
    }

    // 게시판 - 파일 삭제
    public void remove(Integer postNumber){
        fileMapper.deletePost(postNumber);
    }
}
