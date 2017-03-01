package com.html5app.alarmInfo.mapper;

import com.html5app.alarmInfo.entity.Alarminfo;
import com.html5app.alarmInfo.entity.AlarminfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AlarminfoMapper {
    int countByExample(AlarminfoExample example);

    int deleteByExample(AlarminfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Alarminfo record);

    int insertSelective(Alarminfo record);

    List<Alarminfo> selectByExample(AlarminfoExample example);
    
    List<Alarminfo> selectall() throws Exception;

    Alarminfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Alarminfo record, @Param("example") AlarminfoExample example);

    int updateByExample(@Param("record") Alarminfo record, @Param("example") AlarminfoExample example);

    int updateByPrimaryKeySelective(Alarminfo record);

    int updateByPrimaryKey(Alarminfo record);
}