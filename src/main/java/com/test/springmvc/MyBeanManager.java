package com.test.springmvc;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyBeanManager implements ApplicationContextAware {
	static ApplicationContext myContext = null;
	
	@Deprecated
	public static final ApplicationContext getBeanContext(){
		return myContext;
	}

	
/*	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		MyBeanManager.myContext = ctx;
	}*/
	
	static public <T> T getBean(Class<T> glass) {
		return myContext.getBean(glass);
	}
	
	static public Object getBean(String bean) {
		return myContext.getBean(bean);
	}


	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		MyBeanManager.myContext = applicationContext;
		
	}
	
}