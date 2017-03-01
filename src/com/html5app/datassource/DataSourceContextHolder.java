package com.html5app.datassource;


/**
 * 数据源动态切换 （此处设置类型提供给Html5DataSource设置使用）
 * @author SQ
 * 2017年2月20日
 * 上午9:16:14
 */
public class DataSourceContextHolder {
	//创建新线程来动态连接所需要的数据源
	private static final ThreadLocal<String> local = new ThreadLocal<String>();

	
	  public static void setDbType(String dbType) {  
		  local.set(dbType);  
		  System.out.println("该是更改数据库设置");
	    }  
	  
	    public static String getDbType() {  
	        return ((String) local.get());  
	    }  
	  
	    public static void clearDbType() {  
	    	local.remove();  
	    }  
	
}
