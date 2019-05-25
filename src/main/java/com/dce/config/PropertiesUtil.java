package com.dce.config;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dce.util.CommonUtils;


public class PropertiesUtil {

	private static Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);
	
	
	public static Properties getProperties(String fileName) {
		String path = CommonUtils.USER_DIR+CommonUtils.SYSTEM_SEPARATE+"conf"+CommonUtils.SYSTEM_SEPARATE;
		String filePath = path+fileName;
		
		Properties properties = null;
		InputStream in = null;
		try {
			filePath = URLDecoder.decode(filePath, "utf-8");
			in = new BufferedInputStream(new FileInputStream(filePath));
			if(in != null){
				properties = new Properties();
				properties.load(in);
			}
		} catch (Exception e) {
			logger.error("加载配置文件出错[{}]",fileName, e);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					logger.error("加载配置文件关闭出错[{}]", fileName, e);
				}
			}
		}
		return properties;
	}
}
