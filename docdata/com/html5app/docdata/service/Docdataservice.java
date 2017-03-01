package com.html5app.docdata.service;

import java.io.IOException;
import java.util.List;

import com.html5app.docdata.entity.Docdata;

public interface Docdataservice {
	public List<Docdata> selectByExample(Docdata Docdata ,Docdata newDocdata);
	public int jfzs() throws IOException;
	public List jfmc() throws IOException;
	public List<Docdata> sbcx(String jfmc,String sbmc);
}
