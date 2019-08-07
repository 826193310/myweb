package com.su.service;

import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.su.dao.TblFasfdfssaveInfoExtMapper;
import com.su.dao.TblFasfdfssaveInfoMapper;
import com.su.vo.Resp;
import com.su.vo.TblFasfdfssaveInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
*
*@Description: 保存上传 fastDFS 后的文件信息
*@Param:
*@Author: guanzhou.su
*@Date: 2019/8/6
*@return:
 *
**/
@Service
public class FastDfsInfoService {

    @Autowired
    TblFasfdfssaveInfoMapper tblFasfdfssaveInfoMapper;

    @Autowired
    TblFasfdfssaveInfoExtMapper tblFasfdfssaveInfoExtMapper;

    @Autowired
    private FastFileStorageClient storageClient;

    @Transactional
    public Resp<TblFasfdfssaveInfo> saveFileInfo(TblFasfdfssaveInfo info) {
        tblFasfdfssaveInfoMapper.insertSelective(info);
        return new Resp<TblFasfdfssaveInfo>(info);
    }

    /**
     *
     *@Description: 根据保存路径删除图片
     *@Param: [savePath] 图文在存储的路径
     *@Author: guanzhou.su
     *@Date: 2019/8/7
     *@return: com.su.vo.Resp<java.lang.Void>
     *
     **/
    @Transactional
    public Resp<Void> deleteBySavePath(String savePath) {
        storageClient.deleteFile(savePath);
        tblFasfdfssaveInfoExtMapper.deleteBySavePath(savePath);
        return new Resp<Void>();
    }
}
