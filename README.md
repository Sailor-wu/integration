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

