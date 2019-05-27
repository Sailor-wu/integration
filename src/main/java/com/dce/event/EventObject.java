package com.dce.event;

import java.lang.reflect.Method;

/**
 * desc 事件源基类
 * @author wu
 * @date Create in 2019/05/27 10:50:05
 *
 */
public class EventObject {

	/**事件对象*/
	private Object obj;
	/**事件执行的方法*/
	
	private Method method;
	
	/**
	 * desc 构造事件体
	 * @param obj
	 * @param method
	 */
	public EventObject(Object obj, Method method) {
		this.obj = obj;
		this.method = method;
	}
	
	/**事件对象*/
	public Object getObj() {
		return obj;
	}
	/**事件执行的方法*/
	public Method getMethod() {
		return method;
	}
	
	
}
