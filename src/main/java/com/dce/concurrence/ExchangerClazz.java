package com.dce.concurrence;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.dce.console.SystemHandler;

public class ExchangerClazz {

	private static Exchanger<String> exchanger = new Exchanger<String>();
	
	public static void main(String[] args) {
		new SystemHandler().init();
		ExecutorService service = Executors.newFixedThreadPool(2);
		
		service.execute(()->{
			try {
				String exchange = exchanger.exchange("其实我暗恋你很久了...................");
				System.out.println("女孩说："+exchange);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		service.execute(() -> {
			try {
				System.out.println("女生从教室里慢慢的走出来.......");
				TimeUnit.SECONDS.sleep(3);
				String boy = exchanger.exchange("我喜欢你......");
				System.out.println("男孩说："+boy);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
}
