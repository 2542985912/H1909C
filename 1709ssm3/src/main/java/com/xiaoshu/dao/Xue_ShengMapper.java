package com.xiaoshu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xiaoshu.base.dao.BaseMapper;
import com.xiaoshu.entity.XueShengBanJi;
import com.xiaoshu.entity.Xue_Sheng;
import com.xiaoshu.entity.Xue_ShengExample;

public interface Xue_ShengMapper extends BaseMapper<Xue_Sheng> {
    long countByExample(Xue_ShengExample example);

    int deleteByExample(Xue_ShengExample example);

    List<Xue_Sheng> selectByExample(Xue_ShengExample example);

    int updateByExampleSelective(@Param("record") Xue_Sheng record, @Param("example") Xue_ShengExample example);

    int updateByExample(@Param("record") Xue_Sheng record, @Param("example") Xue_ShengExample example);
    
    public List<Xue_Sheng> chaKan();

	List<Xue_Sheng> chaKan(Xue_Sheng x);
	
	public List<XueShengBanJi> chaKanXueShengBanJi();
}