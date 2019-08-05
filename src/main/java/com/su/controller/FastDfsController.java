package com.su.controller;

import com.github.tobato.fastdfs.domain.fdfs.MetaData;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 *
 *@Description: fastDFS 测试controller
 *@Param:
 *@Author: guanzhou.su
 *@Date: 2019/8/5
 *@return:
 *
 **/
@RestController
public class FastDfsController {

    @Autowired
    private FastFileStorageClient storageClient;

    @PostMapping("fast/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        Set<MetaData> metaDataSet = new HashSet<>();
        metaDataSet.add(new MetaData("Author", "Author"));
        metaDataSet.add(new MetaData("date", "当前时间"));
        StorePath path = storageClient.uploadFile(file.getInputStream(), file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()),
                metaDataSet);
        return path.getFullPath();
    }
}
