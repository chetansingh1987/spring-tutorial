package com.configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class MyPropertyConfigurer extends PropertyPlaceholderConfigurer {

    private Map<String, String> mmPropertiesMap;
    private int mmSystemPropertiesMode = SYSTEM_PROPERTIES_MODE_FALLBACK;

    @Override
    public void setSystemPropertiesMode(int systemPropertiesMode) {
        super.setSystemPropertiesMode(systemPropertiesMode);
        mmSystemPropertiesMode = systemPropertiesMode;
    }

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props) throws BeansException {
        super.processProperties(beanFactory, props);

        mmPropertiesMap = new HashMap<String, String>();
        for(Object key : props.keySet()) {
            String keyStr = key.toString();
            String valueStr = resolvePlaceholder(keyStr, props, mmSystemPropertiesMode);
            mmPropertiesMap.put(keyStr, valueStr);
        }
    }

    public String getProperty(String name) {
    	return mmPropertiesMap.containsKey(name)? mmPropertiesMap.get(name).toString().trim() : "";
    }

}