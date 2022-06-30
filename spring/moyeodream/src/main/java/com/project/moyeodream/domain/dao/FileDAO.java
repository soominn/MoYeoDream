package com.project.moyeodream.domain.dao;

import com.project.moyeodream.mapper.FileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FileDAO {
    private final FileMapper fileMapper;
}
