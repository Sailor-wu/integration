package com.dce.event;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dce.event.annotation.LoginInit;

/**
 * desc  事件管理中心
 * @author wu
 * @date Create in 2019/05/27 15:42:11
 *
 */
public class EventManager {

	private static final Logger logger = LoggerFactory.getLogger(EventManager.class);
	
	/** 事件集合 */
	private static HashMap<EventType, List<EventObject>> eventMap = new HashMap<>();
	/**
	 * desc 注册事件，保存到集合
	 * @param cls
	 * @throws Exception
	 */
	public static void register(Class<?> cls) throws Exception{
		// 获取
		Object obj = cls.newInstance();
		
		// 获取对象下所有的方法  
		Method [] methods = cls.getDeclaredMethods();
		for (Method method : methods) {			
			// 获取方法对应下的注解
			Annotation[] arr = method.getAnnotations();
			
			// 分配不同的类型处理不同的注解
			for (Annotation anno : arr) {
				EventType type = getAnnotationKey(anno);
				List<EventObject> list = eventMap.get(type);
				if (list == null) {
					list = new ArrayList<EventObject>();
					eventMap.put(type, list);
				}
				list.add(new EventObject(obj, method));
			}
		}
		
	}
	
	/**
	 * desc 根据注解类型返回对应的枚举key以方便保存到map
	 * @param anno
	 * @return
	 * @throws Exception
	 */
	private static EventType getAnnotationKey(Annotation anno) throws Exception {
		if(anno instanceof LoginInit) {
			return EventType.Logininit;
		}else{
			throw new Exception("annotation key not exist!"+anno.toString());
		}
	}


	/**
	 * desc 事件处理执行
	 * @param evtType
	 */
	public static void executeEvent(EventType evtType,String jsonStr){
		List<EventObject> list = eventMap.get(evtType);
		if(list == null) return;
		for(EventObject evt : list){
			try{
				evt.getMethod().invoke(evt.getObj(),jsonStr);
			}catch(Exception e){
				logger.error("execute event excption, e=", e);
			}
		}
	}
}
