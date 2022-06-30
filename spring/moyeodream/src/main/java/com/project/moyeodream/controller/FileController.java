package com.project.moyeodream.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
@Slf4j
@RequestMapping("/file/*")
public class FileController {
    @ResponseBody
    @PostMapping("/uploadProfile")
    public String uploadProfile(MultipartFile file) throws IOException {
        String rootDirectory = "C:/upload";

        File uploadDirectory = new File(rootDirectory, "profile");
        if(!uploadDirectory.exists()) {uploadDirectory.mkdirs();}

        UUID uuid = UUID.randomUUID();
        String fileName = uuid.toString() + "_" + file.getOriginalFilename();

        File saveFile = new File(uploadDirectory, fileName);
        file.transferTo(saveFile);

        return fileName;
    }

    @DeleteMapping("/deleteProfile")
    @ResponseBody
    public void deleteProfile(String path){
        File file = new File("C:/upload", path);
        if(file.exists()) {file.delete();}
    }

    private String getDateDirectory(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String directory = sdf.format(date);
        return directory;
    }
}
