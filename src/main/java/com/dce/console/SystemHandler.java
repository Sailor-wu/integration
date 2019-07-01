package com.dce.console;


public class SystemHandler implements ConsoleHanlder{

	@Override
	public void save() {
		System.out.println("保存");
	}

	@Override
	public void exit() {
		System.out.println("退出");
	}

	public void init(){
//		//加入关闭服务器的事件
//		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
//			public void run() {
//			}
//		}));
		
		//windows运行控制UI
		String os = System.getProperty("os.name");
		if (os.toLowerCase().startsWith("win")) {
			new Console(this);
		}
	}
	
	@Override
	public String getName() {
		return "abc";
	}
}
