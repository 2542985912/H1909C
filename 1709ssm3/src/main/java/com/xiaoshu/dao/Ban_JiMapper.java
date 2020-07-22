package com.xiaoshu.dao;

import com.xiaoshu.base.dao.BaseMapper;
import com.xiaoshu.entity.Ban_Ji;
import com.xiaoshu.entity.Ban_JiExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Ban_JiMapper extends BaseMapper<Ban_Ji> {
    long countByExample(Ban_JiExample example);

    int deleteByExample(Ban_JiExample example);

    List<Ban_Ji> selectByExample(Ban_JiExample example);

    int updateByExampleSelective(@Param("record") Ban_Ji record, @Param("example") Ban_JiExample example);

    int updateByExample(@Param("record") Ban_Ji record, @Param("example") Ban_JiExample example);
}