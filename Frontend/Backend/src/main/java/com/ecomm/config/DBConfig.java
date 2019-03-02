package com.ecomm.config;

	import java.util.Properties;

	import javax.sql.DataSource;

	import org.hibernate.SessionFactory;
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.ComponentScan;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.jdbc.datasource.DriverManagerDataSource;
    import org.springframework.orm.hibernate5.HibernateTransactionManager;
    import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
    import org.springframework.transaction.annotation.EnableTransactionManagement;


	@Configuration
	@EnableTransactionManagement
	@ComponentScan("com.ecomm")
	public class DBConfig 
	{
		
		
		@Bean(name="dataSource") 
		public DataSource getH2DataSource()
		{
			DriverManagerDataSource dataSource=new DriverManagerDataSource();
			dataSource.setDriverClassName("org.h2.Driver");
			dataSource.setUsername("sa");
			dataSource.setPassword("sa");
			dataSource.setUrl("jdbc:h2:tcp://localhost/~/project1");
			System.out.println("===Creating the DataSource Bean=====");
			return dataSource;
		}
		
		
		@Bean(name="sessionFactory")
		public SessionFactory getSessionFactory()
		{
			Properties hibernateProperties=new Properties();
			hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
			hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
			
			LocalSessionFactoryBuilder factory1=new LocalSessionFactoryBuilder(getH2DataSource());
			factory1.addProperties(hibernateProperties);
			factory1.scanPackages("com");
			SessionFactory sessionFactory=factory1.buildSessionFactory();
			
			System.out.println("===Creating the SessionFactory Bean=====");
			return sessionFactory;
		}
		
	
		
		@Bean(name="txManager")
		public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
		{
			System.out.println("===Creating the TransactionManager Bean=====");
			return new HibernateTransactionManager(sessionFactory);
		}
	}

