package com.dce.base;

import java.io.IOException;
import java.util.Set;

import com.dce.StartMain;
import com.dce.event.EventManager;
import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;

/**
 * desc 系统初始操作
 * @author wu
 * @date Create in 2019/05/27 16:24:31
 *
 */
public class BaseMain {

	public static void load() throws IOException {
		//扫描整个module目录下所有的类找出：系统表对象，事件方法不包含内部类
		Set<ClassInfo> classes = ClassPath.from(StartMain.class.getClassLoader()).getTopLevelClassesRecursive("com.dce.logic");
		for (ClassInfo ci: classes) {
			Class<?> cls  = ci.load();
			try {
				// 注册事件
				EventManager.register(cls);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
