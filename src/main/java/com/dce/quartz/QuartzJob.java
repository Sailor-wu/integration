package com.dce.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dce.event.EventManager;

/**
 * desc 任务Job
 * @author wu
 * @date Create in 2019/06/04 17:53:55
 *
 */
public class QuartzJob implements Job {

	private static final Logger log = LoggerFactory.getLogger(QuartzJob.class);
	
	/**
	 * 提交job 等待定时执行
	 */
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		try {
			String tiggerName = context.getTrigger().getKey().getName();
			if(tiggerName != null ) {
				 EventManager.executeQuartzEvent(Integer.parseInt(tiggerName));
			}
//			log.info("===commit quartz success==========="+tiggerName);
			System.out.println("===commit quartz success==========="+tiggerName);
		} catch (NumberFormatException e) {
			log.info("===commit quartz err==========="+e.getMessage());
		}
	}

}
