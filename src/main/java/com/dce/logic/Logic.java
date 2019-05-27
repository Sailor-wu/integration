package com.dce.logic;

import com.dce.event.annotation.LoginInit;

/**
 * desc 
 * @author wu
 * @date Create in 2019/05/27 16:09:38
 */
public class Logic {

	/**
	 * desc 登录完毕初始化
	 */
	@LoginInit
	public void LoginInit(String jsonStr) {
		System.out.println("===========登录完毕初始化事件。。。。。========="+jsonStr);
	}
	
}
