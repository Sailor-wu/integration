package com.dce.concurrence;


/**
 *  创建是个线程，每隔线程执行count++  100000次
 *  执行十次，相当于 10 * 10000 
 *  看看结果
 * @author wu
 * @date Create in 2019/06/29 15:18:10
 *
 */
public class SyncClazz{

	private static final SyncClazz ins = new SyncClazz();

	public static SyncClazz getInstance() {
		return ins;
	}
	private SyncClazz() {}
	
	private static int count = 0;

//    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            Thread thread = new Thread(new SyncClazz());
//            thread.start();
//        }
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("result: " + count);
//    }

    public  void run() {
    	synchronized (this) {			
//    		for (int i = 0; i < 10000; i++)
    			count++;
		}
    }
    
    public  void getCount() {
    	System.out.println("count \t"+count);
    }
	
}
