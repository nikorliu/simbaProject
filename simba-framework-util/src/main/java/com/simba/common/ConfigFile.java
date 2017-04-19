package com.simba.common;

import org.apache.commons.lang.StringUtils;

/**
 * 获取配置文件的类
 * 
 * @author caozhejun
 *
 */
public class ConfigFile {

	/**
	 * 获取配置文件的文件名
	 * 
	 * @return
	 */
	public static String getFileName() {
		String fileName = "/configs.properties";
		String env = System.getenv("ENV");
		if (StringUtils.isNotEmpty(env)) {
			if ("qa".equalsIgnoreCase(env)) {
				fileName = "/configs_qa.properties";
			} else if ("prod".equalsIgnoreCase(env)) {
				fileName = "/configs_prod.properties";
			}
		}
		return fileName;
	}

}
