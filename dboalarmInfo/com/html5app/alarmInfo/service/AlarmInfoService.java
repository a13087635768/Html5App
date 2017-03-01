package com.html5app.alarmInfo.service;

import java.util.List;

import com.html5app.alarmInfo.entity.Alarminfo;

public interface AlarmInfoService {
	public List<Alarminfo> selectByExample( Alarminfo  alarmInfo );
	public List<Alarminfo> selectall() throws Exception;


}
