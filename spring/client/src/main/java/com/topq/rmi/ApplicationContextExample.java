package com.topq.rmi;

import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.skyfence.management.cm.facade.ConfigurationFacade;
import com.skyfence.management.cm.model.asset.Asset;


public class ApplicationContextExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/liel/ran/applicationContext.xml");
		
		ConfigurationFacade facade = (ConfigurationFacade)context.getBean("configurationFacade");
		Set<Asset> assets = facade.getAssets();
		for (Asset asset : assets) {
			System.out.println(asset.getName());
		}
		
	}

}
