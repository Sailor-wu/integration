package com.dce.quartz.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * desc  定时事件注解
 * @author wu
 * @date Create in 2019/06/04 18:04:01
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface FixedTimeQuartz {

	/**
	 * desc 触发的时间,对应quartz的job
	 * @return
	 */
	String time();
}
