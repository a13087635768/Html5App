package com.html5app.datassource;


/**
 * ����Դ��̬�л� ���˴����������ṩ��Html5DataSource����ʹ�ã�
 * @author SQ
 * 2017��2��20��
 * ����9:16:14
 */
public class DataSourceContextHolder {
	//�������߳�����̬��������Ҫ������Դ
	private static final ThreadLocal<String> local = new ThreadLocal<String>();

	
	  public static void setDbType(String dbType) {  
		  local.set(dbType);  
		  System.out.println("���Ǹ������ݿ�����");
	    }  
	  
	    public static String getDbType() {  
	        return ((String) local.get());  
	    }  
	  
	    public static void clearDbType() {  
	    	local.remove();  
	    }  
	
}
