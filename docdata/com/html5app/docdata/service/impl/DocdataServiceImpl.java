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
 * @param Docdata （前时间段）
 * @param newDocdata （后时间段）
 * @return 查询结果
 */
	DocdataExample docdataExample = new DocdataExample();
	public List<Docdata> selectByExample(Docdata Docdata ,Docdata newDocdata){
		//时间段查询
		if(Docdata.getDatatime()!=null){
			DocdataExample docdataExample = new DocdataExample();
			Criteria createCriteria = docdataExample.createCriteria();
			createCriteria.andDatatimeBetween(Docdata.getDatatime(), newDocdata.getDatatime());
			List<Docdata> selectByExample = docdataMapper.selectByExample(docdataExample);
			return selectByExample;
		//名称查询
		}else if(Docdata.getDoctagname()!=null&&newDocdata==null){
			DocdataExample docdataExample = new DocdataExample();
			Criteria createCriteria = docdataExample.createCriteria();
			createCriteria.andDoctagnameLike("%"+Docdata.getDoctagname()+"%");
			List<Docdata> selectByExample = docdataMapper.selectByExample(docdataExample);
			return selectByExample;
		//value值查询
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
	 * 查询机房总数
	 */
	public int jfzs() throws IOException{
		return  jfmc().size();
	}
	/**
	 * 查询所有机房名称
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
