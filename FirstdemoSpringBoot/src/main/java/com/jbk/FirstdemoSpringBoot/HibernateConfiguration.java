package com.jbk.FirstdemoSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.jbk.hibernatePOJO.Country;
import com.jbk.hibernatePOJO.EmployeeHibernate;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan("com.jbk.hibernatePOJO")
public class HibernateConfiguration {
	
	@Autowired
	private ApplicationContext context;

	 
	@Bean
	public LocalSessionFactoryBean getSessionFactory()  
	{
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setConfigLocation(context.getResource("classpath:hibernate.cfg.xml"));
		factoryBean.setAnnotatedClasses(EmployeeHibernate.class,Country.class);
		return factoryBean;
	}
}
