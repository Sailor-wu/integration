package com.dce.log;

import java.net.URL;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
/**
 * desc 日志配置项
 * @author wu
 * @date Create in 2019/05/25 16:12:34
 *
 */
public class LogBack {

	public static void initLogBack() throws JoranException {
		
		URL url = LogBack.class.getClassLoader().getResource("logback.xml");
		/**
		 * 获取日志上下文对象
		 */
		LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
		JoranConfigurator configurator = new JoranConfigurator();
		
		configurator.setContext(context);
		
		context.reset();
		
		configurator.doConfigure(url);
		
	}
}
