package com.su.controller;

import com.github.tobato.fastdfs.domain.fdfs.MetaData;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.su.service.FastDfsInfoService;
import com.su.vo.Resp;
import com.su.vo.TblFasfdfssaveInfo;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 *@Description: fastDFS 测试controller
 *@Author: guanzhou.su
 *@Date: 2019/8/5
 *
 **/
@RestController
public class FastDfsController {

    @Value("${fdfs.stroageUrl}" + "/")
    private String fastdfsStroageUrl;

    @Autowired
    private FastFileStorageClient storageClient;

    @Autowired
    FastDfsInfoService fastDfsInfoService;

    @PostMapping("fast/upload")
    public Resp<TblFasfdfssaveInfo> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        Set<MetaData> metaDataSet = new HashSet<>();
        metaDataSet.add(new MetaData("Author", "Author"));
        metaDataSet.add(new MetaData("date", "当前时间"));
        StorePath path = storageClient.uploadFile(file.getInputStream(), file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()),
                metaDataSet);
        TblFasfdfssaveInfo info = new TblFasfdfssaveInfo();
        info.setFileName(file.getOriginalFilename());
        String savePath = path.getFullPath();
        info.setSavePath(savePath);
        info.setUrl(fastdfsStroageUrl + savePath);
        info.setcTime(new Date());
        info.setuTime(new Date());
        return fastDfsInfoService.saveFileInfo(info);
    }

    /**
    *
    *@Description: 删除文件
    *@Param:
    *@Author: guanzhou.su
    *@Date: 2019/8/6
    *@return:
     *
    **/
    @PostMapping("fast/delete/")
    public String delete(@RequestParam("file") MultipartFile file) throws IOException {
        //storageClient.deleteFile();
        return null;
    }
}
