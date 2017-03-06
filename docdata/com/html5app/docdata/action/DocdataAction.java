package com.html5app.docdata.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.html5app.docdata.service.Docdataservice;
import com.html5app.datassource.DataSourceContextHolder;
import com.html5app.docdata.entity.Docdata;
import com.html5app.docdata.entity.DocdataTimeAvgValue;
import com.html5app.docdatamaputil.Maputil;

import net.sf.json.JSONObject;
/**
 * 多数据源 在使用Service时请先设置使用的数据库
 * DataSourceContextHolder.setDbType("dataSource1");
 * @author SQ
 * 2017年2月20日
 * 上午9:37:42
 */
@Controller
public class DocdataAction {
	@Resource
	public Docdataservice docdataService;
	
	/**
	 * 暂时停止使用 暂停时间 2017年3月3日 启用 selectavgvalue接口
	 * @author SQ
	 * @param Startdate 起始时间     yyyy-MM-dd HH:mm:ss
	 * @param enddate	结束时间    yyyy-MM-dd HH:mm:ss
	 * @throws ParseException 时间解析异常错误码  1000
	 * @throws IOException 查询结果输出异常 1001
	 * @update 2017年3月3日   修改为指定机房的指定设备一段时间内的值
	 * @param jfmc 机房名称
	 */
	@RequestMapping(value="datatime")
	public void datatime(String Startdate , String enddate ,HttpServletResponse response,String jfmc ) throws IOException {
		DataSourceContextHolder.setDbType("dataSource1");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Date Startparse =null;
		 Date endparse = null;
			JSONObject jsonObject = new  JSONObject();
			PrintWriter out = response.getWriter();

		try {
			 Startparse = simpleDateFormat.parse(Startdate);
			 endparse = simpleDateFormat.parse(enddate);
		} catch (ParseException e) {
			//返回string错误码
			try {
				response.getWriter().print("1000");
				jsonObject.put("error","1000");
				out.print(jsonObject.toString());
				
			} catch (IOException e1) {
				response.getWriter().print("1001");
				jsonObject.put("error","1001");
				out.print(jsonObject.toString());
				
			}
			
		}
		
		Docdata docdata = new Docdata();
		docdata.setDatatime(Startparse);
		//**********update*************//
		docdata.setDoctagname(jfmc);
		//********update end************//
		Docdata newdocdata = new Docdata();
		newdocdata.setDatatime(endparse);
		List<Docdata> list = docdataService.selectByExample(docdata,newdocdata);
		List Xdata= new ArrayList();
		List Ydata= new ArrayList();
		 SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
		
	for (Docdata docdata2 : list) {
		String str = sdf.format(docdata2.getDatatime());
		Xdata.add(str);
		Ydata.add(docdata2.getDocvalue());
	}
		jsonObject.put("Xdata", Xdata);
		jsonObject.put("Ydata", Ydata);
		out.print(jsonObject.toString());
		

		
	}
	
	

	
	/**
	 * 机房名称查询
	 * @param doctagname 查询名称
	 * @param open  为1时查询所有设备名称以及参数 否则查询全部
	 * @throws IOException 输出对象错误
	 * @return devicename 改名称所拥有的设备
	 * @return data 改名称所拥有的设备以及参数列表
	 */
	

	
	@RequestMapping(value="doctagname")
	public void doctagname(String doctagname,HttpServletResponse response) throws IOException{
		DataSourceContextHolder.setDbType("dataSource1");
		PrintWriter writer = response.getWriter();
		Docdata docdata = new Docdata();
		docdata.setDoctagname(doctagname);
		List<Docdata> selectByExample = docdataService.selectByExample(docdata, null);
		JSONObject jsonObject = new  JSONObject();
			jsonObject.put("data", selectByExample);
		jsonObject.put("devicename",Maputil.devicenamech(jsonObject.toString()));
		writer.print(jsonObject.toString());
		
	}
	
	/**
	 * 
	 * @param docvalue 查询状态（查询value）修改需求后不要了！~ 不写了
	 */
	@RequestMapping("docvalue")
	public void docvalue(Float docvalue,HttpServletResponse response){
		DataSourceContextHolder.setDbType("dataSource1");
		Docdata docdata = new Docdata();
		docdata.setDocvalue(docvalue);
		List<Docdata> selectByExample = docdataService.selectByExample(docdata, null);
		JSONObject jsonObject = new  JSONObject();
		jsonObject.put("data", selectByExample);
	}
	
	
	/**
	 * 返回详细设备列表（例如 机房1 ups 的数量）
	 * @param response 
	 *  @param jfmc 机房名称 
	 *   @param sbmc  设备名称
	 * @throws IOException 
	 * @return 返回去除机房名称的设备列表
	 */
	@RequestMapping("sbxq")
	public void sbxq(HttpServletResponse response ,String jfmc,String sbmc) throws IOException{
		DataSourceContextHolder.setDbType("dataSource1");
		PrintWriter out = response.getWriter();
		List<Docdata> sbcx = docdataService.sbcx(jfmc,sbmc);
		List<Docdata> sbmcxg = Maputil.sbmcxg(sbcx);
		JSONObject jsonObject = new  JSONObject();
		jsonObject.put("data", sbmcxg);
		out.print(jsonObject.toString());
		
	}
	/**
	 * 查询当天的平均历史曲线
	 * @param date 查询的时间
	 * @param jfmc 机房名称设备名称参数名称
	 * @throws IOException out对象异常
	 */
	@RequestMapping("selectavgvalue")
	public void selectavgvalue(String date  ,HttpServletResponse response,String jfmc) throws IOException{
		//每个小时的值
		Map<String, String> datavalue= new HashMap<String, String>();
		datavalue.put("1", "0");
		datavalue.put("2", "0");
		datavalue.put("3", "0");
		datavalue.put("4", "0");
		datavalue.put("5", "0");
		datavalue.put("6", "0");
		datavalue.put("7", "0");
		datavalue.put("8", "0");
		datavalue.put("9", "0");
		datavalue.put("10", "0");
		datavalue.put("11", "0");
		datavalue.put("12", "0");
		datavalue.put("13", "0");
		datavalue.put("14", "0");
		datavalue.put("15", "0");
		datavalue.put("16", "0");
		datavalue.put("17", "0");
		datavalue.put("18", "0");
		datavalue.put("19", "0");
		datavalue.put("20", "0");
		datavalue.put("21", "0");
		datavalue.put("22", "0");
		datavalue.put("23", "0");
		datavalue.put("24", "0");
		DataSourceContextHolder.setDbType("dataSource1");
		 SimpleDateFormat simpleDateFormat =   new SimpleDateFormat( "yyyy-MM-dd" );
		JSONObject jsonObject = new  JSONObject();
		PrintWriter out = response.getWriter();
		Calendar calendar = Calendar.getInstance();   
		Date  Startparse = null;
		Date  endparse = null;
		try {
			Startparse = simpleDateFormat.parse(date);
		} catch (ParseException e) {
			response.getWriter().print("1000");
			jsonObject.put("error","1000");
			out.print(jsonObject.toString());
		}
		calendar.setTime(Startparse);
		//给传过来的时间+1天  进行查询 形成时间段
		calendar.add(Calendar.DAY_OF_MONTH, +1);
		endparse = calendar.getTime();
		
		//将map 转为list 返回json
		List<String> hhvalue = new ArrayList<String>();
		List<DocdataTimeAvgValue> selectavgvalue = docdataService.selectavgvalue(jfmc, Startparse, endparse);
		//添加到map 中
		for (DocdataTimeAvgValue docdataTimeAvgValue : selectavgvalue) {
			String hh = docdataTimeAvgValue.getHh();
			datavalue.put(hh, docdataTimeAvgValue.getValueavg());
		}
		//map 转为 list
		for (int i = 0; i <datavalue.size(); i++) {
			
			hhvalue.add(datavalue.get(i+""));
		}
		jsonObject.put("data", hhvalue);
		out.print(jsonObject.toString());
	    
	}
	

	
	public Docdataservice getDocdataService() {
		return docdataService;
	}

	public void setDocdataService(Docdataservice docdataService) {
		this.docdataService = docdataService;
	}
}
