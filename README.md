"integration �ۺ�"

??????



??????????


???jar?

<!-- ???? -->
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

????jta ????java.lang.NoClassDefFoundError: javax/transaction/UserTransaction 

1.quartz?????????????FixedTimeQuartz.java?,?????????quartz.properties????????????quartz_jobs.xml?
??????????????JobStoreRunner.java???????????
????????????QuartzJob.java?????

2.?????/com/dce/quartz/annotation/FixedTimeQuartz.java?????  ???????

3.??????????????????EventManager.java?????????????????????????

4.??????AnnotationLogic.java??????????????????????????@FixedTimeQuartz?

5.????StartMain.java?

