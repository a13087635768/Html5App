package com.html5app.docdata.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.html5app.datassource.DataSourceContextHolder;
import com.html5app.docdata.service.Docdataservice;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import sun.misc.Contended;
/**
 *
 * @author SQ
 * 2017��2��20��
 * ����9:37:42
 */
@Controller
public class JfcxAction {
	@Resource
	public Docdataservice docdataService;
	
	/**
	 * ��ѯ��������
	 * @author SQ
	 * @param response
	 * @param open 1 Ϊ��ѯ��������  0Ϊ����ѯ����
	 * @throws IOException 1002 ��ȡ�ļ��쳣
	 * @return ����jfsz Ϊ��������  dataΪ ��������
	 */
	
	@RequestMapping(value="jfzs")
	public void jfzs(HttpServletResponse response ,int open  ) throws IOException{
		
		
		PrintWriter out = response.getWriter();
		if(open==1){
			try {
				int jfzs = docdataService.jfzs();
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("jfzs", jfzs);
				List jfmc = docdataService.jfmc();
				JSONArray fromObject = JSONArray.fromObject(jfmc);
				jsonObject.put("data", fromObject.toString());
				out.print(jsonObject.toString());
				
			} catch (Exception e) {
				JSONObject jsonObject = new  JSONObject();
				jsonObject.put("error", "1002");
				
				out.print(jsonObject.toString());
				
			}
		}else{
			
			try {
				int jfzs = docdataService.jfzs();
				JSONObject jsonObject = new  JSONObject();
				jsonObject.put("jfzs",jfzs);
				out.print(jsonObject.toString());
				
			} catch (IOException e) {
				JSONObject jsonObject = new  JSONObject();
				jsonObject.put("error", "1002");
				out.print(jsonObject.toString());
				

			}
			
		}
		
	}

	
	public Docdataservice getDocdataService() {
		return docdataService;
	}

	public void setDocdataService(Docdataservice docdataService) {
		this.docdataService = docdataService;
	}
	
	
	
	
	
}
