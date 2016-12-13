package cz.darujdetem.web.config;

import javax.sql.DataSource;

import org.apache.ibatis.transaction.TransactionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.ResourceTransactionManager;

import cz.darujdetem.web.db.MyBatisDaoPackageMarker;
import cz.darujdetem.web.service.data.DataServicePackageMarker;

/**
 * @author Martin Strejc
 *
 */
@Configuration
@MapperScan(basePackageClasses={MyBatisDaoPackageMarker.class})
@ComponentScan(basePackageClasses = {DataServicePackageMarker.class})
public class DataAccessConfig {

	@Value("classpath:mybatis-mapperConfig.xml")
	private Resource myBatisConfig;
	
	@javax.annotation.Resource(mappedName = "jdbc/daruj")
	private DataSource dataSource;

	@Autowired	// (required = false)
	private TransactionFactory transactionFactory;

	@Bean 
	public SqlSessionFactoryBean sqlSessionFactory() {
		SqlSessionFactoryBean sqlSessionFactory;
		sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource);
		sqlSessionFactory.setTransactionFactory(transactionFactory);
		sqlSessionFactory.setConfigLocation(myBatisConfig);
		return sqlSessionFactory;
	}
	
	@Bean
	public ResourceTransactionManager txManager() {
		return new DataSourceTransactionManager(dataSource);
	}
	
	@Bean
	public TransactionFactory transactionFactory() {
		return new SpringManagedTransactionFactory();
	}

}
