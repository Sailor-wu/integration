package com.dce.concurrence;

public class TestSync {

	public static void main(String[] args) {
		Thread thread = null;
		for (int i = 0; i < 100; i++) {
			thread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					SyncClazz.getInstance().run();
				}
			});
			thread.start();
			SyncClazz.getInstance().getCount();
		}
		
	}
}
