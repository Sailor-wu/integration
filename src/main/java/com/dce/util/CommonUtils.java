package com.dce.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * desc 系统常量工具类
 * @author wu
 * @date Create in 2019/05/25 16:35:32
 *
 */
public class CommonUtils {

	private static final Logger logger = LoggerFactory.getLogger(CommonUtils.class);
	
	/**
	 * 操作系统分隔符
	 */
	public static String SYSTEM_SEPARATE = System.getProperty("file.separator");
	/**
	 * 工程的绝对地址,直接定位到bin外的目录
	 */
	public static String USER_DIR = System.getProperty("user.dir");
	/**
	 * 下载日志的基础目录,通过读取logback.xml配置
	 */
	public static String LOG_DOWNLOAD_DIR;
	
	
}
