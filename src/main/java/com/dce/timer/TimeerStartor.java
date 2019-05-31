package com.dce.timer;

import java.util.Timer;

/**
 * desc Timer 定时器
 * @author wu
 * @date Create in 2019/05/31 10:33:39
 *
 */
public class TimeerStartor {

	public static void main(String[] args) {
		// 创建调度器  Timer 
		Timer timer = new Timer();
		long delay  =  1000;  // 延迟
		long period =  5000;  //周期
		TimerJob job = new TimerJob("Sailor");
		// 从现在开始 每隔五秒执行一次 job
		timer.schedule(job, delay, period);
		
		
		long delay1  =  1000;  // 延迟
		long period2 =  1000;  //周期
		TimerJob job1 = new TimerJob("Tony");
		// 从现在开始 每隔1秒执行一次 job
		timer.schedule(job1, delay1, period2);
	}
}
