package com.topq.rmi;

import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.skyfence.management.cm.facade.ConfigurationFacade;
import com.skyfence.management.cm.model.asset.Asset;
import com.topq.rmi.config.ConfigurationFacadeBean;


public class JavaConfigExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationFacadeBean.class);
		ConfigurationFacade facade = (ConfigurationFacade)context.getBean("configurationFacade");
		Set<Asset> assets = facade.getAssets();
		for (Asset asset : assets) {
			System.out.println(asset.getName());
		}
		
	}

}
