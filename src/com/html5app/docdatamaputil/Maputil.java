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
	 * ���Ҫת���ĸ�ʽ
	 */
	static {
		//���İ�
		MCMAP.put("wsd", "��ʪ��");
		MCMAP.put("dly", "������");
		MCMAP.put("ups", "UPS");
		MCMAP.put("kt", "�յ�");
		MCMAP.put("dc", "���");
		//��ѹ
		//����

		// ����ĸ��
		MCMAPCH.put("wsd", "wsd");
		MCMAPCH.put("dly", "dly");
		MCMAPCH.put("ups", "ups");
		MCMAPCH.put("kt", "kt");
		MCMAPCH.put("dc", "dc");

		// ����
		DOCDATAMAP.put("jf", "����");

		// ��ʪ��
		DOCDATAMAP.put("wsd", "��ʪ��");
		DOCDATAMAP.put("wd", "�¶�");
		DOCDATAMAP.put("sd", "ʪ��");

		// ������
		DOCDATAMAP.put("dly", "������");
		DOCDATAMAP.put("abxdy", "AB�ߵ�ѹ");

		// UPS
		DOCDATAMAP.put("ups", "UPS");
		DOCDATAMAP.put("srgl", "���빦��");
		DOCDATAMAP.put("scgl", "�������");

		// �յ�
		DOCDATAMAP.put("kt", "�յ�");
		DOCDATAMAP.put("hfwd", "�ط��¶�");
		DOCDATAMAP.put("hfsd", "�ط�ʪ��");

		// �̸�
		DOCDATAMAP.put("yg", "�̸�");
		// ��©
		DOCDATAMAP.put("cl", "��©");
		// �¸�
		DOCDATAMAP.put("wg", "�¸�");
		// ��ؼ��
		DOCDATAMAP.put("dcdy", "��ص�ѹ");
		DOCDATAMAP.put("dcjc", "��ؼ��");

	}

	/**
	 * ��jsonת��Ϊ����
	 * 
	 * @author SQ
	 * @param changecode
	 * @return ת������ַ���
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
	 * ���ش˻�����ʲô�豸�����İ棩
	 * 
	 * @param devicename
	 *            json�ַ���
	 * @return �豸����
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
	 * ���ش˻�����ʲô�豸������ĸ�棩
	 * 
	 * @param devicename
	 * @return �豸����
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
 * ����ȥ����������
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
