package com.dce.quartz;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * desc 定时任务  1. 调度器   2.任务 3.  触发器
 * 
 * @author wu
 * @date Create in 2019/05/30 16:09:07
 */
public class JobStoreRunner {
	private static final Logger logger = LoggerFactory.getLogger(JobStoreRunner.class); 
	// 调度器
	private static Scheduler scheduler = null;
	
	/**
	 * desc 开启任务
	 * @throws SchedulerException 
	 */
	public static void start() {
		// 加载定时配置信息 读取
		try {
			SchedulerFactory factory = new StdSchedulerFactory("quartz.properties");
			// 创建scheduler
			scheduler = factory.getScheduler();
			// 启动
			scheduler.start();
//			logger.info(" quartz server start success. ");
			System.out.println(" quartz server start success. ");
		} catch (SchedulerException e) {
			logger.info(" quartz server start err.."+e.getMessage());
		}
	}
	
	/**
	 * desc 停止
	 */
	public static void shutdown(){
		if(scheduler != null) {
			try {
				scheduler.shutdown();
//				logger.info(" quartz shutdown success. ");
				System.out.println(" quartz shutdown success. ");
			} catch (SchedulerException e) {
				logger.info(" quartz shutdown exception..."+e.getMessage());
			}
		}
	}
	
}
