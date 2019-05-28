package com.dce;

import java.io.IOException;

import com.dce.base.BaseMain;
import com.dce.config.SysConfig;
import com.dce.event.EventManager;
import com.dce.event.EventType;
import com.dce.log.LogBack;

import ch.qos.logback.core.joran.spi.JoranException;

public class StartMain {

	public static void main(String[] args) throws IOException {
		try {
			
			LogBack.initLogBack();
			// 加载配置项信息
			SysConfig.initConfig("sysconfig.properties");
			System.out.println(SysConfig.IP);
			System.out.println("扫描注解，注册event事件");
			BaseMain.load();
			System.out.println("扫描注解，注册event事件   succ  ");
			// 调用事件处理方法
			String jsonStr="{age:18}";
			EventManager.executeEvent(EventType.Logininit,jsonStr);
			
		} catch (JoranException e) {
			e.printStackTrace();
		}
	}
}
