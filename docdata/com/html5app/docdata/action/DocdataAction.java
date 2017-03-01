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
	 * @author SQ
	 * @param Startdate ��ʼʱ��     yyy/mm/dd/HH/mm
	 * @param enddate	����ʱ��    yyy/mm/dd/HH/mm
	 * @throws ParseException ʱ������쳣������  1000
	 * @throws IOException ��ѯ�������쳣 1001
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
			//����string������
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

	public Docdataservice getDocdataService() {
		return docdataService;
	}

	public void setDocdataService(Docdataservice docdataService) {
		this.docdataService = docdataService;
	}
}
