package com.imcs.maven.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class DBCPDataSourceFactory {

	public DataSource getDataSource() {
		Properties props = new Properties();
		InputStream fis = null;

		BasicDataSource ds = new BasicDataSource();
		try {
			fis = getClass().getResourceAsStream("/db.properties");
			props.load(fis);
		} catch (IOException exp) {
			exp.printStackTrace();
		}

		ds.setDriverClassName(props.getProperty("MYSQL_DB_DRIVER_CLASS"));
		ds.setUrl(props.getProperty("MYSQL_DB_URL"));
		ds.setUsername(props.getProperty("MYSQL_DB_USERNAME"));
		ds.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));

		return ds;
	}

}
