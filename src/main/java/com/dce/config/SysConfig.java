package com.dce.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * desc 系统配置项
 * @author wu
 * @date Create in 2019/05/25 16:12:59
 *
 */
public class SysConfig {

	/**ip*/
	public static String IP = null;
	
	/**端口*/
	public static String PORT = null;
	
	/**boolean*/
	public static boolean IS_RIGHT = false;
	
	/**
	 * desc 读取指定属性文件，获取配置属性信息
	 * @param fileName
	 */
	public static void initConfig(String fileName) {
		
//		Properties properties = PropertiesUtil.getProperties(fileName);
		
		InputStream stream = PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName);
        Properties properties = new Properties();
        try {
        	properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
		if(properties.containsKey("ip")) {
			IP = properties.getProperty("ip");
		}
		
		if(properties.containsKey("port")) {
			PORT = properties.getProperty("port");
		}
		
		if(properties.containsKey("is_right")) {
			IS_RIGHT =Boolean.valueOf(properties.getProperty("is_right"));
		}
		
		
	}
	
	
}
