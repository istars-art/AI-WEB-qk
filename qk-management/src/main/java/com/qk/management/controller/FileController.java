package com.qk.management.controller;

import com.alibaba.oss.core.AliYunOssTemplate;
import com.qk.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author 33465
 * @created 2026/4/25 下午8:03
 * @desciption
 */
@Slf4j
@RestController
public class FileController {
    @Autowired
    private AliYunOssTemplate aliYunOssTemplate;


    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        String url = aliYunOssTemplate.upload(image.getInputStream(), image.getOriginalFilename());
        log.info("文件上传成功：{}", url);
        return Result.success(url);
    }
}
   