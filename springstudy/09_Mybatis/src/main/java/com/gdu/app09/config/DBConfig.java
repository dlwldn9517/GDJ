package com.gdu.app09.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/*
	@PropertySource
	안녕. 난 프로퍼티 파일을 참조할 수 있는 애너테이션이야.
*/
@PropertySource(value = {"mybatis/config/db/properties"})

@EnableTransactionManagement
@EnableAspectJAutoProxy
@Configuration
public class DBConfig {

	
	// db.properties 파일을 읽어서 변수에 저장하기
	// ${프로퍼티명}
	@Value(value = "${driver}")
	private String driver;
	
	@Value(value = "${url}")
	private String url;
	
	@Value(value = "${username}")
	private String username;
	
	@Value(value = "${password}")
	private String password;
	
	
	// HikariConfig
	@Bean
	public HikariConfig config() {
		HikariConfig config = new HikariConfig();
		config.setDriverClassName(driver);
		config.setJdbcUrl(url);
		config.setUsername(username);
		config.setPassword(password);
		return config;
	}
	
	
	// HikariDataSource
	@Bean(destroyMethod="close")
	public HikariDataSource dataSource() {
		return new HikariDataSource(config());
	}
	
	
	// TransactionManager
	@Bean
	public TransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
	
}
