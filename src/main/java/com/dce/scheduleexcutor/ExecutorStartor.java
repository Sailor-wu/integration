package com.dce.scheduleexcutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * desc scheduleExecutor测试类
 * .创建线程池执行线程
 * @author wu
 * @date Create in 2019/05/31 11:06:40
 *
 */
public class ExecutorStartor {

	public static void main(String[] args) {
		// 创建线程池  给两个线程数
		ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
		/**
		 * 创建并执行在给定延迟后启用的一次性操作。
		 参数：
		 command - 要执行的任务
		 delay - 从现在开始延迟执行的时间  5
		 unit - 延迟参数的时间单位
		 */
		service.schedule(new ExcuteJob("Sailor Job"), 5, TimeUnit.SECONDS);
		/**
		 * 创建并执行一个在给定初始延迟后首次启用的定期操作，后续操作具有给定的周期；
		     也就是将在 initialDelay 后开始执行，然后在 initialDelay+period 后执行，接着在 initialDelay + 2 * period 后执行，依此类推。
		     如果任务的任何一个执行遇到异常，则后续执行都会被取消。否则，只能通过执行程序的取消或终止方法来终止该任务。
		     如果此任务的任何一个执行要花费比其周期更长的时间，则将推迟后续执行，但不会同时执行。
		     参数：
		     command - 要执行的任务
		     initialDelay - 首次执行的延迟时间
		     period - 连续执行之间的周期
		     unit - initialDelay 和 period 参数的时间单位
		 */
		service.scheduleAtFixedRate(new ExcuteJob("Tony Job"), 1, 500, TimeUnit.MILLISECONDS);
		/**
		 * 创建并执行一个在给定初始延迟后首次启用的定期操作，
		     随后，在每一次执行终止和下一次执行开始之间都存在给定的延迟。
		     如果任务的任一执行遇到异常，就会取消后续执行。
		     否则，只能通过执行程序的取消或终止方法来终止该任务。
		     参数：
		     command - 要执行的任务
		     initialDelay - 首次执行的延迟时间
		     delay - 一次执行终止和下一次执行开始之间的延迟
		     unit - initialDelay 和 delay 参数的时间单位
		 */
		service.scheduleWithFixedDelay(new ExcuteJob("Coco Job"), 1, 500, TimeUnit.MILLISECONDS);
		
		
		service.scheduleAtFixedRate(new ExcuteJob(" Tony1 Job"), 1, 500, TimeUnit.MILLISECONDS);
		
		service.scheduleWithFixedDelay(new ExcuteJob("Coco1 Job"), 1, 500, TimeUnit.MILLISECONDS);
	}
}
