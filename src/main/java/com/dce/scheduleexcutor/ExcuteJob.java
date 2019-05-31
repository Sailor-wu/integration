package com.dce.scheduleexcutor;

/**
 * desc 执行的任务Job 
 * .实现Runnable接口 重写Run方法
 * @author wu
 * @date Create in 2019/05/31 11:02:22
 */
public class ExcuteJob implements Runnable{

	private String jobName;
	
	public ExcuteJob(String jobName) {
		this.jobName = jobName;
	}

	/**
	 * 具体执行的任务
	 */
	@Override
	public void run() {
		System.out.println("Job:"+jobName+"   是线程："+Thread.currentThread().getName()+"在执行。");
	}
	
}
