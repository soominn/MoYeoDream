package com.project.moyeodream.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class FileVO {
    private String fileName;
    private String uploadDirectory;
    private PostVO postVO;
}
