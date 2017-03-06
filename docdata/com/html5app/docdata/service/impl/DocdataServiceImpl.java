package com.html5app.docdata.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import com.html5app.docdata.service.Docdataservice;
import com.html5app.docdata.entity.Docdata;
import com.html5app.docdata.entity.DocdataExample;
import com.html5app.docdata.entity.DocdataTimeAvgValue;
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
 * @update 指定机房设备一段时间内查询
 */
	DocdataExample docdataExample = new DocdataExample();
	public List<Docdata> selectByExample(Docdata Docdata ,Docdata newDocdata){
		//时间段查询
		if(Docdata.getDatatime()!=null){
			DocdataExample docdataExample = new DocdataExample();
			docdataExample.setOrderByClause("Datatime");
			Criteria createCriteria = docdataExample.createCriteria();
			//********update************
			//createCriteria.andDatatimeBetween(Docdata.getDatatime(), newDocdata.getDatatime());
			 createCriteria.andDatatimeBetween(Docdata.getDatatime(), newDocdata.getDatatime());
			 createCriteria.andDoctagnameEqualTo(Docdata.getDoctagname());
			 
			//********update end********
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
	
	
    public List<DocdataTimeAvgValue> selectavgvalue(String name,Date date ,Date enddate){
    	List<DocdataTimeAvgValue> selectavgvalue = docdataMapper.selectavgvalue(name, date, enddate);
    	return selectavgvalue;
    }

	
	
	public DocdataMapper getDocdataMapper() {
		return docdataMapper;
	}
	public void setDocdataMapper(DocdataMapper docdataMapper) {
		this.docdataMapper = docdataMapper;
	}
	
	

}
