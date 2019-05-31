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


java RMI
	远程方法调用，他支持存储于不同地址空间的程序级对象之间批次进行通讯，实现远程对象之间的无缝远程调用
	
	交互步骤
		1.Server端创建远程对象骨架（skeleton）
		2.注册远程对象到RMI Registry
		3.Client访问（RMI Registry）并查找注册的远程对象
		4.RMI Registry 返回服务器远程对象的存根（stub）保存
		5.客户端调用远程对象的方法
		6.客户端本地存根和服务器骨架通信
		7.服务器骨架代理调用方法
		8.实际处理对象返回方法的执行结果
		9.服务器骨架返回结果给Client本地存根
		10.存根把结果返回给Client

RMI构成部分
	第一个是RMIregistry	
	第二个是server端程序
	第三个是Client端程序
	
	首先启动RMIregistry服务，启动时候指定服务器监听的端口，（默认的端口是1099）。

	其次，服务器端程序实例化一个提供服务的实现类，然后通过RMI 提供的Naming/Context/Registry(下面Registry实例)等类的bind或者rebind方法将实例注册到RMIregistry上，并且对外暴露一个名称。
	
	最后，Client端程序通过本地接口和一个名称（RMIregistry对外暴露的名称）在使用RMI提供的Naming/COntext/Registry邓磊分lookup方法从RMIservice那里拿到实现类。这样虽然本地没有这个类的实现类，但所有的方法都在接口里了，便可以实现远程调用对象的方法了。

		Client													Server
		  |														   |
	-------------											-------------
	|	存根	|											|	骨架网		|
	|	stub	|											|	skeleton	|
	------------											-------------
		|															|
		|															|
		-------------------------------------------------------------
							远程引用层
		-------------------------------------------------------------
		|															|
		|															|	
		传输层					<---------->					 传输层


方法调用从客户对象经存根（stub）、远程引用层（Remote Reference Layer）和传输层（Transport Layer）向下，传递给主机，然后再次经传输层，向上穿过远程调用层和骨干网（Skeleton），到达服务器对象。
存根扮演着远程服务器对象的代理的角色，使该对象可被客户激活。
远程引用层处理语义、管理单一或多重对象的通信，决定调用是应发往一个服务器还是多个。
传输层管理实际的连接，并且追踪可以接受方法调用的远程对象。
骨干网完成对服务器对象实际的方法调用，并获取返回值。
返回值向下经远程引用层、服务器端的传输层传递回客户端，再向上经传输层和远程调用层返回。最后，存根获得返回值。






