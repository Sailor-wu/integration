package com.dce.logic;

import com.dce.quartz.annotation.FixedTimeQuartz;

/**
 * desc 定时时间注解
 * @author wu
 * @date Create in 2019/06/04 18:05:55
 */
public class AnnotationLogic {

	/**
	 * desc 处理定时------半小时事件
	 */
	@FixedTimeQuartz(time = "2")
	public void QuartzAnnotation() {
		System.out.println("执行定时事件............................半小时事件");
	}
	
}
