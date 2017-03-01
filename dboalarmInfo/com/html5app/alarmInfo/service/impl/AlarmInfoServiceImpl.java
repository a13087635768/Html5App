package com.html5app.alarmInfo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.html5app.alarmInfo.entity.Alarminfo;
import com.html5app.alarmInfo.entity.AlarminfoExample;
import com.html5app.alarmInfo.entity.AlarminfoExample.Criteria;
import com.html5app.alarmInfo.mapper.AlarminfoMapper;
import com.html5app.alarmInfo.service.AlarmInfoService;

public class AlarmInfoServiceImpl implements AlarmInfoService{
	@Resource
	AlarminfoMapper alarminfoMapper;
	
	public List<Alarminfo> selectByExample( Alarminfo  alarmInfo ){
		AlarminfoExample alarminfoExample =  new  AlarminfoExample();
		Criteria createCriteria = alarminfoExample.createCriteria();
		createCriteria.andAlmpositionEqualTo(alarmInfo.getAlmposition());
		List<Alarminfo> selectByExample = alarminfoMapper.selectByExample(alarminfoExample);
		return selectByExample;
	}
	
	
	public List<Alarminfo> selectall() throws Exception{
		List<Alarminfo> selectall = alarminfoMapper.selectall();
		return selectall;
		
	}

	public AlarminfoMapper getAlarminfoMapper() {
		return alarminfoMapper;
	}

	public void setAlarminfoMapper(AlarminfoMapper alarminfoMapper) {
		this.alarminfoMapper = alarminfoMapper;
	}

	


	
}
