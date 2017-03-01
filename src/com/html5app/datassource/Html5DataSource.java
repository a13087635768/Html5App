package com.html5app.datassource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 多数据源自动切换
 * @author SQ
 * 2017年2月20日
 * 上午8:57:39
 */
public class Html5DataSource extends AbstractRoutingDataSource   {

	
//实现AbstractRoutingDataSource类 （他实现了DataSource接口）


	@Override
	protected Object determineCurrentLookupKey() {
		return DataSourceContextHolder.getDbType();

	}
	
	


}
