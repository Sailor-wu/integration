"integration ×ÛºÏ"

添加注解事件



使用注解创建定时任务


用到的jar包

<!-- 定时任务 -->
		<dependency>
			<groupId>org.quartz-scheduler</groupId>
			<artifactId>quartz</artifactId>
			<version>2.3.0</version>
		</dependency>
		<dependency>
			<groupId>org.quartz-scheduler</groupId>
			<artifactId>quartz-jobs</artifactId>
			<version>2.3.0</version>
		</dependency>
		<dependency>
			<groupId>javax.transaction</groupId>
			<artifactId>jta</artifactId>
			<version>1.1</version>
		</dependency>

如果没用jta 包。会报java.lang.NoClassDefFoundError: javax/transaction/UserTransaction 

1.quartz包下创建定时任务管理中心（FixedTimeQuartz.java）,包括加载配置文件（quartz.properties），加载具体的定时任务（quartz_jobs.xml）
创建定时任务中心（调度器）（JobStoreRunner.java），负责开启和停止整个
创建任务执行控制中心（（QuartzJob.java）执行任务

2.创建注解（/com/dce/quartz/annotation/FixedTimeQuartz.java）定义注解  设置触发的时间

3.事件管理中心帮忙解析和注册定时事件（EventManager.java），扫描指定的包下的注解信息，注册到任务执行中心。

4.具体的任务（AnnotationLogic.java），创建需要执行的具体实现任务。使用创建的注解信息（@FixedTimeQuartz）

5.测试类（StartMain.java）



java 几种调度任务介绍
1. Timer
    核心的一个taskList 和一个 TaskThread . timer 将接受到的任务，丢到tasklist 里面，tasklist将按照task的最初执行时间进行排序。TimerThread会在创建Timer的时候创建一个守护线程，这个线程轮询执行所有的任务。执行完毕后休眠，等待到达最近要执行的任务的时间点的时候，TimeThread被唤醒执行任务。执行完，没有任务的时候，继续休眠。
    优点：简单易用。
    缺点：由于所有的线程都是由同一个线程来调度，因此所有的任务执行都是串行执行的，同一时间只能有一个任务在执行，前一个任务的延迟将影响后一个任务的执行。
2. ScheduledExecutor
    基于Timer缺陷设计，思想：每一个被调度的任务都会有线程池中的一个线程去执行，因此任务是并发执行的，相互之间不会受到干扰。需要注意的是，只有当任务的执行时间到来的时候，ScheduleExecutor才会真正启动一个线程去处理，其余时间都是在做轮询状态。
3. Quartz
    Quartz 可以满足更多更复杂的调度需求
