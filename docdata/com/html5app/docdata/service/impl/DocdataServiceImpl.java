package com.html5app.docdata.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import com.html5app.docdata.service.Docdataservice;
import com.html5app.docdata.entity.Docdata;
import com.html5app.docdata.entity.DocdataExample;
import com.html5app.docdata.entity.DocdataExample.Criteria;
import com.html5app.docdata.mapper.DocdataMapper;


public class DocdataServiceImpl implements Docdataservice {
	@Resource
	public DocdataMapper docdataMapper;

/**
 * @author SQ
 * @param Docdata ��ǰʱ��Σ�
 * @param newDocdata ����ʱ��Σ�
 * @return ��ѯ���
 */
	DocdataExample docdataExample = new DocdataExample();
	public List<Docdata> selectByExample(Docdata Docdata ,Docdata newDocdata){
		//ʱ��β�ѯ
		if(Docdata.getDatatime()!=null){
			DocdataExample docdataExample = new DocdataExample();
			Criteria createCriteria = docdataExample.createCriteria();
			createCriteria.andDatatimeBetween(Docdata.getDatatime(), newDocdata.getDatatime());
			List<Docdata> selectByExample = docdataMapper.selectByExample(docdataExample);
			return selectByExample;
		//���Ʋ�ѯ
		}else if(Docdata.getDoctagname()!=null&&newDocdata==null){
			DocdataExample docdataExample = new DocdataExample();
			Criteria createCriteria = docdataExample.createCriteria();
			createCriteria.andDoctagnameLike("%"+Docdata.getDoctagname()+"%");
			List<Docdata> selectByExample = docdataMapper.selectByExample(docdataExample);
			return selectByExample;
		//valueֵ��ѯ
		}else if(Docdata.getDocvalue()!=null&&newDocdata==null){
			DocdataExample docdataExample = new DocdataExample();
			Criteria createCriteria = docdataExample.createCriteria();
			Criteria andDocvalueEqualTo = createCriteria.andDocvalueEqualTo(Docdata.getDocvalue());
			List<Docdata> selectByExample = docdataMapper.selectByExample(docdataExample);
			return selectByExample;
		}else{
			return null;
		}
	}
	
	
	/**
	 * ��ѯ��������
	 */
	public int jfzs() throws IOException{
		return  jfmc().size();
	}
	/**
	 * ��ѯ���л�������
	 * 
	 * @return
	 * @throws IOException 
	 */
	public List jfmc() throws IOException{
		Properties prop=new Properties();
		InputStream inputStream = this.getClass().getResourceAsStream("jfpz.properties");
		prop.load(inputStream);
		String str = (String)prop.get("jfmc");
		String[] split = str.split(",");
		List<String> List = Arrays.asList(split);
		return List;
	}
	public List<Docdata> sbcx(String jfmc,String sbmc){
		DocdataExample docdataExample = new DocdataExample();
		Criteria createCriteria = docdataExample.createCriteria();
		createCriteria.andDoctagnameLike("%"+jfmc+"_"+sbmc+"%");
		List<Docdata> selectByExample = docdataMapper.selectByExample(docdataExample);
		return selectByExample;
	}
	
	public DocdataMapper getDocdataMapper() {
		return docdataMapper;
	}
	public void setDocdataMapper(DocdataMapper docdataMapper) {
		this.docdataMapper = docdataMapper;
	}
	
	

}
