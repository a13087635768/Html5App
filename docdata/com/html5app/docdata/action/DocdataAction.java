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
 * ������Դ ��ʹ��Serviceʱ��������ʹ�õ����ݿ�
 * DataSourceContextHolder.setDbType("dataSource1");
 * @author SQ
 * 2017��2��20��
 * ����9:37:42
 */
@Controller
public class DocdataAction {
	@Resource
	public Docdataservice docdataService;
	
	/**
	 * ��ʱֹͣʹ�� ��ͣʱ�� 2017��3��3�� ���� selectavgvalue�ӿ�
	 * @author SQ
	 * @param Startdate ��ʼʱ��     yyyy-MM-dd HH:mm:ss
	 * @param enddate	����ʱ��    yyyy-MM-dd HH:mm:ss
	 * @throws ParseException ʱ������쳣������  1000
	 * @throws IOException ��ѯ�������쳣 1001
	 * @update 2017��3��3��   �޸�Ϊָ��������ָ���豸һ��ʱ���ڵ�ֵ
	 * @param jfmc ��������
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
			//����string������
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
	 * �������Ʋ�ѯ
	 * @param doctagname ��ѯ����
	 * @param open  Ϊ1ʱ��ѯ�����豸�����Լ����� �����ѯȫ��
	 * @throws IOException ����������
	 * @return devicename ��������ӵ�е��豸
	 * @return data ��������ӵ�е��豸�Լ������б�
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
	 * @param docvalue ��ѯ״̬����ѯvalue���޸������Ҫ�ˣ�~ ��д��
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
	 * ������ϸ�豸�б����� ����1 ups ��������
	 * @param response 
	 *  @param jfmc �������� 
	 *   @param sbmc  �豸����
	 * @throws IOException 
	 * @return ����ȥ���������Ƶ��豸�б�
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
	 * ��ѯ�����ƽ����ʷ����
	 * @param date ��ѯ��ʱ��
	 * @param jfmc ���������豸���Ʋ�������
	 * @throws IOException out�����쳣
	 */
	@RequestMapping("selectavgvalue")
	public void selectavgvalue(String date  ,HttpServletResponse response,String jfmc) throws IOException{
		//ÿ��Сʱ��ֵ
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
		//����������ʱ��+1��  ���в�ѯ �γ�ʱ���
		calendar.add(Calendar.DAY_OF_MONTH, +1);
		endparse = calendar.getTime();
		
		//��map תΪlist ����json
		List<String> hhvalue = new ArrayList<String>();
		List<DocdataTimeAvgValue> selectavgvalue = docdataService.selectavgvalue(jfmc, Startparse, endparse);
		//��ӵ�map ��
		for (DocdataTimeAvgValue docdataTimeAvgValue : selectavgvalue) {
			String hh = docdataTimeAvgValue.getHh();
			datavalue.put(hh, docdataTimeAvgValue.getValueavg());
		}
		//map תΪ list
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
