package com.su.service;

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

    @Transactional
    public Resp<TblFasfdfssaveInfo> saveFileInfo(TblFasfdfssaveInfo info) {
        tblFasfdfssaveInfoMapper.insertSelective(info);
        return new Resp<TblFasfdfssaveInfo>(info);
    }
}
