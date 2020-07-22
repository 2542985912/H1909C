package com.xiaoshu.dao;

import com.xiaoshu.base.dao.BaseMapper;
import com.xiaoshu.entity.gongsi;
import com.xiaoshu.entity.gongsiExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface gongsiMapper extends BaseMapper<gongsi> {
    long countByExample(gongsiExample example);

    int deleteByExample(gongsiExample example);

    List<gongsi> selectByExample(gongsiExample example);

    int updateByExampleSelective(@Param("record") gongsi record, @Param("example") gongsiExample example);

    int updateByExample(@Param("record") gongsi record, @Param("example") gongsiExample example);
}