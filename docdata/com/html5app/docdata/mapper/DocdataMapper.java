package com.html5app.docdata.mapper;

import com.html5app.docdata.entity.Docdata;
import com.html5app.docdata.entity.DocdataExample;
import com.html5app.docdata.entity.DocdataKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DocdataMapper {
    int countByExample(DocdataExample example);

    int deleteByExample(DocdataExample example);

    int deleteByPrimaryKey(DocdataKey key);

    int insert(Docdata record);

    int insertSelective(Docdata record);

    List<Docdata> selectByExample(DocdataExample example);

    Docdata selectByPrimaryKey(DocdataKey key);

    int updateByExampleSelective(@Param("record") Docdata record, @Param("example") DocdataExample example);

    int updateByExample(@Param("record") Docdata record, @Param("example") DocdataExample example);

    int updateByPrimaryKeySelective(Docdata record);

    int updateByPrimaryKey(Docdata record);
}