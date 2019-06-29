package com.dce.concurrence;

/**
 * .死锁 例子 这个demo中，开启了两个线程threadA, threadB,其中threadA占用了resource_a,
 * .并等待被threadB释放的resource _b。
 * .threadB占用了resource _b正在等待被threadA释放的resource_a。因此threadA,threadB出现线程安全的问题，形成死锁。
 * @author wu
 * @date Create in 2019/06/29 14:19:25
 * 
 */
public class DeadLockDemo {

	/** 共享资源A*/
	private static String resource_a = "A";
	/** 共享资源B*/
	private static String resource_b = "B";
	
	
	public static void deadLock() {
	
		Thread threada = new Thread(new Runnable() {
			// 操作a的同时还需要拿到b资源
			@Override
			public void run() {
				synchronized (resource_a) {
					System.out.println("资源A"+resource_a);
					try {
						Thread.sleep(2000);
						synchronized (resource_b) {
							System.out.println("资源B"+resource_b);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		Thread threadb = new Thread(new Runnable() {
			// 操作b的同时还需要拿到a资源
			@Override
			public void run() {
				synchronized (resource_b) {
					System.out.println("资源B"+resource_b);
					try {
						Thread.sleep(2000);
						synchronized (resource_a) {
							System.out.println("资源A"+resource_a);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		threada.start();
		threadb.start();
		
	}
	/**
	 * 启动之后，两个线程分别获得了对方的资源，并且不释放。双方都在等待释放
	 * 可以通过jstack 命令查看信息
	 * cmd ---> jstack pid 回车查看
	 * 避免死锁
	 * 1.避免一个线程同时获得多个锁。
	 * 2.避免一个线程在锁的内部占用多个资源，尽量保障一个锁一个资源
	 * 3.可以尝试定时锁，使用Lock.tryLock(timeout) 线程超时不会阻塞
	 * 4.对于数据库锁，加锁和解锁必须在同一个连接里面，否则会出现解锁失败
	 * @param args
	 */
	public static void main(String[] args) {
		deadLock();
	}
	
}
