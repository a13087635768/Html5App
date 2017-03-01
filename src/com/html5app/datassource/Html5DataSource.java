package com.html5app.datassource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * ������Դ�Զ��л�
 * @author SQ
 * 2017��2��20��
 * ����8:57:39
 */
public class Html5DataSource extends AbstractRoutingDataSource   {

	
//ʵ��AbstractRoutingDataSource�� ����ʵ����DataSource�ӿڣ�


	@Override
	protected Object determineCurrentLookupKey() {
		return DataSourceContextHolder.getDbType();

	}
	
	


}
