package com.html5app.docdatamaputil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.html5app.docdata.entity.Docdata;

public class Maputil {
	public static final Map<String, String> DOCDATAMAP = new HashMap<String, String>();
	public static final Map<String, String> MCMAP = new HashMap<String, String>();
	public static final Map<String, String> MCMAPCH = new HashMap<String, String>();

	/**
	 * 添加要转换的格式
	 */
	static {
		//中文版
		MCMAP.put("wsd", "温湿度");
		MCMAP.put("dly", "电量仪");
		MCMAP.put("ups", "UPS");
		MCMAP.put("kt", "空调");
		MCMAP.put("dc", "电池");
		//电压
		//列阻

		// 首字母版
		MCMAPCH.put("wsd", "wsd");
		MCMAPCH.put("dly", "dly");
		MCMAPCH.put("ups", "ups");
		MCMAPCH.put("kt", "kt");
		MCMAPCH.put("dc", "dc");

		// 整体
		DOCDATAMAP.put("jf", "机房");

		// 温湿度
		DOCDATAMAP.put("wsd", "温湿度");
		DOCDATAMAP.put("wd", "温度");
		DOCDATAMAP.put("sd", "湿度");

		// 电量仪
		DOCDATAMAP.put("dly", "电量仪");
		DOCDATAMAP.put("abxdy", "AB线电压");

		// UPS
		DOCDATAMAP.put("ups", "UPS");
		DOCDATAMAP.put("srgl", "输入功率");
		DOCDATAMAP.put("scgl", "输出功率");

		// 空调
		DOCDATAMAP.put("kt", "空调");
		DOCDATAMAP.put("hfwd", "回风温度");
		DOCDATAMAP.put("hfsd", "回风湿度");

		// 烟感
		DOCDATAMAP.put("yg", "烟感");
		// 侧漏
		DOCDATAMAP.put("cl", "侧漏");
		// 温感
		DOCDATAMAP.put("wg", "温感");
		// 电池检测
		DOCDATAMAP.put("dcdy", "电池电压");
		DOCDATAMAP.put("dcjc", "电池检测");

	}

	/**
	 * 将json转换为中文
	 * 
	 * @author SQ
	 * @param changecode
	 * @return 转换后的字符串
	 */
	public static String change(String changecode) {
		String temp = changecode;
		for (String s : DOCDATAMAP.keySet()) {
			if (temp.lastIndexOf(s) != -1) {
				temp = temp.replace(s, DOCDATAMAP.get(s));
			}
		}
		return temp;
	}

	/**
	 * 返回此机房有什么设备（中文版）
	 * 
	 * @param devicename
	 *            json字符串
	 * @return 设备名称
	 */
	public static List devicename(String devicename) {
		String temp = devicename;
		Set<String> set = new HashSet<String>();
		ArrayList<String> arrayList = new ArrayList<String>();
		for (String s : MCMAP.keySet()) {
			if (temp.lastIndexOf(s) != -1) {
				set.add(MCMAP.get(s));
			}
		}
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			arrayList.add(it.next());
		}
		Collections.sort(arrayList);
		return arrayList;
	}

	/**
	 * 返回此机房有什么设备（首字母版）
	 * 
	 * @param devicename
	 * @return 设备名称
	 */
	public static List devicenamech(String devicename) {
		String temp = devicename;
		Set<String> set = new HashSet<String>();
		ArrayList<String> arrayList = new ArrayList<String>();
		for (String s : MCMAPCH.keySet()) {
			if (temp.lastIndexOf(s) != -1) {
				set.add(MCMAPCH.get(s));
			}
		}
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			arrayList.add(it.next());
		}
		Collections.sort(arrayList);
		return arrayList;
	}
/**
 * 用来去除机房名称
 * @param list
 * @return list
 */
	public static List<Docdata> sbmcxg(List<Docdata> list) {
		List<Docdata> newlist= new ArrayList<Docdata>();
		for (int i = 0; i < list.size(); i++) {
			int indexOf = list.get(i).getDoctagname().indexOf('_');
			String substring = list.get(i).getDoctagname().substring(indexOf+1);
			System.out.println(substring);
			Docdata docdata = list.get(i);
			docdata.setDoctagname(substring);
			newlist.add(docdata);
		}
		return newlist;
	}

}
