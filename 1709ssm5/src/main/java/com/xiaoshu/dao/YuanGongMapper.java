package com.xiaoshu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xiaoshu.base.dao.BaseMapper;
import com.xiaoshu.entity.YuanGong;
import com.xiaoshu.entity.YuanGongExample;

public interface YuanGongMapper extends BaseMapper<YuanGong> {
    long countByExample(YuanGongExample example);

    int deleteByExample(YuanGongExample example);

    List<YuanGong> selectByExample(YuanGongExample example);

    int updateByExampleSelective(@Param("record") YuanGong record, @Param("example") YuanGongExample example);

    int updateByExample(@Param("record") YuanGong record, @Param("example") YuanGongExample example);
    
    public List<YuanGong> chaKan(YuanGong y);
}