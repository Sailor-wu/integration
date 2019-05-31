package com.dce.timer;

import java.util.TimerTask;

/**
 * desc 创建定时任务处理类，继承TimerTask  重写润的方法
 * .把要执行的定时操作 写在RUN方法里面
 * @author wu
 * @date Create in 2019/05/31 10:35:04
 *
 */
public class TimerJob extends TimerTask{

	// 任务名字
	private  String jobName = "";
	
	public TimerJob(String jobName) {
		this.jobName = jobName;
	}
	
	@Override
	public void run() {
		System.out.println("I'm the one who does the real work. My name is "+jobName);
	}

}
