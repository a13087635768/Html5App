package com.html5app.docdata.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.html5app.docdata.service.Docdataservice;
import com.html5app.datassource.DataSourceContextHolder;
import com.html5app.docdata.entity.Docdata;
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
	 * @author SQ
	 * @param Startdate 起始时间     yyy/mm/dd/HH/mm
	 * @param enddate	结束时间    yyy/mm/dd/HH/mm
	 * @throws ParseException 时间解析异常错误码  1000
	 * @throws IOException 查询结果输出异常 1001
	 */
	@RequestMapping(value="datatime")
	public void datatime(String Startdate , String enddate ,HttpServletResponse response) throws IOException {
		DataSourceContextHolder.setDbType("dataSource1");

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy/mm/dd/HH/mm");
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
				jsonObject.put("errorcode","1001");
				out.print(jsonObject.toString());
				
			}
			
		}
		
		Docdata docdata = new Docdata();
		docdata.setDatatime(Startparse);
		Docdata newdocdata = new Docdata();
		newdocdata.setDatatime(endparse);
		List<Docdata> list = docdataService.selectByExample(docdata,newdocdata);
		jsonObject.put("data", list);
		jsonObject.put("errorcode",null);
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

	public Docdataservice getDocdataService() {
		return docdataService;
	}

	public void setDocdataService(Docdataservice docdataService) {
		this.docdataService = docdataService;
	}
}
