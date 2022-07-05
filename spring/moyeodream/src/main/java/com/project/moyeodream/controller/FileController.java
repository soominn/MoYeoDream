package com.project.moyeodream.controller;

import com.project.moyeodream.domain.dao.FileDAO;
import com.project.moyeodream.domain.vo.FileVO;
import com.project.moyeodream.domain.vo.JobpostingDTO;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@Slf4j
@RequestMapping("/file/*")
public class FileController {
    @ResponseBody
    @PostMapping("/uploadStudy")
    public List<FileVO> uploadStudy(MultipartFile[] files) throws IOException {
        List<FileVO> fileList = new ArrayList<>();
        String rootDirectory = "C:/upload";

        File uploadDirectory = new File(rootDirectory, getDateDirectory());
        if(!uploadDirectory.exists()) {uploadDirectory.mkdirs();}

        for(MultipartFile file : files) {
            log.info("------------------------------------");
            log.info("upload file name : " + file.getOriginalFilename());
            log.info("upload file size : " + file.getSize());
            FileVO fileVO = new FileVO();

            UUID uuid = UUID.randomUUID();
            String fileName = uuid.toString() + "_" + file.getOriginalFilename();

            fileVO.setFileName(fileName);
            fileVO.setUploadDirectory(getDateDirectory());

            File saveFile = new File(uploadDirectory, fileName);
            file.transferTo(saveFile);

            fileList.add(fileVO);
        }
        return fileList;
    }

    @ResponseBody
    @GetMapping("/displayStudy")
    public byte[] displayStudy(String path) throws IOException {
        return FileCopyUtils.copyToByteArray(new File("C:/upload/" + path));
    }

    @ResponseBody
    @PostMapping("/uploadProfile")
    public String uploadProfile(MultipartFile file) throws IOException {
        String rootDirectory = "C:/upload";

        File uploadDirectory = new File(rootDirectory, "profile");
        if (!uploadDirectory.exists()) {
            uploadDirectory.mkdirs();
        }

        UUID uuid = UUID.randomUUID();
        String fileName = uuid.toString() + "_" + file.getOriginalFilename();

        File saveFile = new File(uploadDirectory, fileName);
        file.transferTo(saveFile);

        return fileName;
    }

    @GetMapping("displayProfile")
    @ResponseBody
    public byte[] getProfile(String path) throws IOException {
        return FileCopyUtils.copyToByteArray(new File("C:/upload/profile/" + path));
    }

    @ResponseBody
    @DeleteMapping("/deleteProfile")
    public void deleteProfile(String path) {
        File file = new File("C:/upload/profile", path);
        if (file.exists()) {
            file.delete();
        }
    }

    private String getDateDirectory() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String directory = sdf.format(date);
        return directory;
    }


    @ResponseBody
    @PostMapping("/uploadCompanyLogo")
    public String uploadCompanyLogo(MultipartFile file) throws IOException {
        String rootDirectory = "C:/upload";

        File uploadDirectory = new File(rootDirectory, "logo");
        if (!uploadDirectory.exists()) {
            uploadDirectory.mkdirs();
        }

        UUID uuid = UUID.randomUUID();
        String fileName = uuid.toString() + "_" + file.getOriginalFilename();

        File saveFile = new File(uploadDirectory, fileName);
        file.transferTo(saveFile);

        return fileName;
    }

    @GetMapping("displayCompanyLogo")
    @ResponseBody
    public byte[] getCompanyLogo(String path) throws IOException {
        return FileCopyUtils.copyToByteArray(new File("C:/upload/logo/" + path));
    }

    @DeleteMapping("/deleteCompanyLogo")
    @ResponseBody
    public void deleteCompanyLogo(String path) {
        File file = new File("C:/upload/logo/", path);
        if (file.exists()) {
            file.delete();
        }
    }

    // 자유게시판 이미지 업로드
    @PostMapping("/uploadPostFile")
    @ResponseBody
    public List<FileVO> uploadPostImage(MultipartFile[] files) throws Exception {
        log.info("--------------------------------------------");
        log.info(files.toString());

        List<FileVO> fileList = new ArrayList<>();

        String rootDirectory = "C:/upload/post";
        File uploadDirectory = new File(rootDirectory, getDateDirectory());
        if (!uploadDirectory.exists()) {
            uploadDirectory.mkdirs();
        }

        UUID uuid = UUID.randomUUID();

        for (MultipartFile file : files) {
            log.info("--------------------------------------------");
            log.info("upload file name : " + file.getOriginalFilename());
            log.info("upload.file size : " + file.getSize());

            // 뷰로 보낼 파일객체
            FileVO fileVO = new FileVO();

            String fileName = uuid.toString() + "_" + file.getOriginalFilename();
            fileVO.setFileName(fileName);

            File saveFile = new File(uploadDirectory, fileName);
            file.transferTo(saveFile);
            fileVO.setUploadDirectory(getDateDirectory());
            log.info("여기까지 완료");

            FileOutputStream thumbnail = new FileOutputStream(new File(uploadDirectory, "t_" + fileName));

            Thumbnailator.createThumbnail(file.getInputStream(), thumbnail, 300, 300);
            thumbnail.close();

            fileList.add(fileVO);
        }
        return fileList;
    }

    // 자유게시판 - 썸네일 주소 전달
    @GetMapping("/displayPostFile")
    @ResponseBody
    public byte[] getFile(String path) throws IOException {
        return FileCopyUtils.copyToByteArray(new File("C:/upload/post/" + path));
    }

    @ResponseBody
    public void deletePostImage(){

    }


    @ResponseBody
    @PostMapping("/uploadInquiry")
    public List<FileVO> uploadInquiry(MultipartFile[] files) throws IOException {
        List<FileVO> fileList = new ArrayList<>();
        String rootDirectory = "C:/upload";

        File uploadDirectory = new File(rootDirectory, getDateDirectory());
        if(!uploadDirectory.exists()) {uploadDirectory.mkdirs();}

        for(MultipartFile file : files) {
            log.info("------------------------------------");
            log.info("upload file name : " + file.getOriginalFilename());
            log.info("upload file size : " + file.getSize());
            FileVO fileVO = new FileVO();

            UUID uuid = UUID.randomUUID();
            String fileName = uuid.toString() + "_" + file.getOriginalFilename();

            fileVO.setFileName(fileName);
            fileVO.setUploadDirectory(getDateDirectory());

            File saveFile = new File(uploadDirectory, fileName);
            file.transferTo(saveFile);

            fileList.add(fileVO);
        }
        return fileList;
    }

    @ResponseBody
    @GetMapping("/displayInquiry")
    public byte[] displayInquiry(String path) throws IOException {
        return FileCopyUtils.copyToByteArray(new File("C:/upload/" + path));
    }


    @ResponseBody
    @PostMapping("/uploadJobposting")
    public List<FileVO> uploadJobposting(MultipartFile[] files) throws IOException {
        List<FileVO> fileList = new ArrayList<>();
        String rootDirectory = "C:/upload";

        File uploadDirectory = new File(rootDirectory, getDateDirectory());
        if(!uploadDirectory.exists()) {uploadDirectory.mkdirs();}

        for(MultipartFile file : files) {
            log.info("------------------------------------");
            log.info("upload file name : " + file.getOriginalFilename());
            log.info("upload file size : " + file.getSize());
            FileVO fileVO = new FileVO();

            UUID uuid = UUID.randomUUID();
            String fileName = uuid.toString() + "_" + file.getOriginalFilename();

            fileVO.setFileName(fileName);
            fileVO.setUploadDirectory(getDateDirectory());

            File saveFile = new File(uploadDirectory, fileName);
            file.transferTo(saveFile);

            fileList.add(fileVO);
        }
        return fileList;
    }

    @ResponseBody
    @GetMapping("/displayJobposting")
    public byte[] displayJobposting(String path) throws IOException {
        return FileCopyUtils.copyToByteArray(new File("C:/upload/" + path));
    }

}