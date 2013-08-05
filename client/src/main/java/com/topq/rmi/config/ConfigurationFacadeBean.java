package com.topq.rmi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration 
public class ConfigurationFacadeBean {

	
	@Bean(name="configurationFacade")
	public org.springframework.remoting.rmi.RmiProxyFactoryBean rmiProxyFactoryBean(){
 
		org.springframework.remoting.rmi.RmiProxyFactoryBean rmi= new org.springframework.remoting.rmi.RmiProxyFactoryBean();
		rmi.setServiceInterface(com.skyfence.management.cm.facade.ConfigurationFacade.class);
		rmi.setServiceUrl("rmi://10.1.1.131:1099/ConfigurationFacadeImpl");
		
		return rmi;
 
	}
}
