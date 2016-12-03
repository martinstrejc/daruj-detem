package cz.darujdetem.web.config;
///**
// * 
// */
//package cz.kandr.conf;
//
//import javax.sql.DataSource;
//
//import org.apache.ibatis.transaction.TransactionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.Resource;
//
//import cz.kandr.db.dao.DataServicePackageMarker;
//import cz.kandr.db.mybatis.dao.MyBatisDaoPackageMarker;
//
///**
// * @author martin
// *
// */
//@Configuration
//@MapperScan(basePackageClasses={MyBatisDaoPackageMarker.class})
//@ComponentScan(basePackageClasses = {DataServicePackageMarker.class})
//public class DataAccessConfig {
//
//	@Value("classpath:mybatis-mapperConfig.xml")
//	private Resource myBatisConfig;
//	
//	@javax.annotation.Resource(mappedName = "jdbc/kandr")
//	private DataSource dataSource;
//
//	@Autowired(required = false)
//	private TransactionFactory transactionFactory;
//
//	@Bean 
//	public SqlSessionFactoryBean sqlSessionFactory() {
//		SqlSessionFactoryBean sqlSessionFactory;
//		sqlSessionFactory = new SqlSessionFactoryBean();
//		sqlSessionFactory.setDataSource(dataSource);
//		sqlSessionFactory.setTransactionFactory(transactionFactory);
//		sqlSessionFactory.setConfigLocation(myBatisConfig);
//		return sqlSessionFactory;
//	}
//	
//
//}
