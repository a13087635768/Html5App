package com.html5app.alarmInfo.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.html5app.alarmInfo.entity.Alarminfo;
import com.html5app.alarmInfo.service.AlarmInfoService;
import com.html5app.datassource.DataSourceContextHolder;

import net.sf.json.JSONObject;

@Controller

public class AlarmInfoAction {
	@Resource 
	AlarmInfoService alarmInfoService;
	/**
	 * 根据报警位置查询
	 * @param almposition  报警地点
	 * @param response
	 * @throws IOException 获取out对象异常 
	 * @return data为结果
	 */
	@RequestMapping("almposition")
	public void almposition(String almposition ,HttpServletResponse response) throws IOException{
		DataSourceContextHolder.setDbType("dataSource2");
		Alarminfo alarminfo = new Alarminfo();
		alarminfo.setAlmposition(almposition);
		List<Alarminfo> selectByExample = alarmInfoService.selectByExample(alarminfo);
		JSONObject jsonObject = new  JSONObject();
		jsonObject.put("data", selectByExample);
		PrintWriter out = response.getWriter();
		out.print(jsonObject.toString());
		
	}
	
	
	/**
	 * 查询所有报警信息
	 * @throws IOException 1003 数据库读取异常
	 * 
	 */
	@RequestMapping("allalmposition")
	public void allalmposition(HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		DataSourceContextHolder.setDbType("dataSource2");
		JSONObject jsonObject = new  JSONObject();
		
		try {
			List<Alarminfo> selectall = alarmInfoService.selectall();
			jsonObject.put("data",selectall);
			out.print(jsonObject.toString());
			
		} catch (Exception e) {
			jsonObject.put("error", "1003");
			out.print(jsonObject.toString());
			
		}
		
	}
	
	
	
	public AlarmInfoService getAlarmInfoService() {
		return alarmInfoService;
	}
	public void setAlarmInfoService(AlarmInfoService alarmInfoService) {
		this.alarmInfoService = alarmInfoService;
	}



	
}
