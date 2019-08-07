package com.su.dao;

import com.su.vo.TblFasfdfssaveInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblFasfdfssaveInfoExtMapper {

    int deleteBySavePath(@Param("savePath") String savePath);
}