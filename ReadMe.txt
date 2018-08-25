----------SpringCloudEureka--------------
1.简单的两个eureka相互注册的例子
2.在hosts文件中，修改
    127.0.0.1 peer1
    127.0.0.1 peer2
3.启动时报错，没有关系
4.http://peer2:8001查看启动情况
-----------SpringCloudProducer----------
将服务注册到peer2上，因为单机情况
-----------SpringCloudProducer2----------
1.producer的第二个实例，同一个服务，生成2个实例，只是端口号不同
-----------SpringCloudConsumer-----------
0.将服务注册到peer2上，因为单机情况
1.先启动SpringCloudProducer，然后启动SpringCloudConsumer
2.http://http://192.168.0.100:8764/hello?name=zhangsan，然后网页显示，hello zhangsan，这里是 SpringCloudProducer,端口是9000
    说明调用成功
3.使用Feign
4.添加hystrix支持，其中对于生产者的接口，有两个实现：一个是Feign实现，正常的调用；一个是本服务的实现，用来处理熔断的情况
5.同时启动2个生产者，用consumer调用，不断刷新网页，会发现端口会在9000和9002之间随机跳动，说明回应的是2个服务。
    关闭其中一个，刷新网页，会发现返回的是，"hello XXX，这里是 SpringCloudProducer,端口是9002"和"hello XXX,!  sorry ,error !"
    之间跳动（开始时），说明熔断处理成功。
6.添加hystrix的dashboard支持，feign和hystrix-dashboard一起使用，还要解决一些问题，用到了再来研究（可以用，但我没配置好）。
------------SpringCloudRibbon------------
1.Ribbon是一个负载均衡客户端，可以很好的控制http和tcp的一些行为。
2.Feign默认集成了ribbon。
3.若同时启动producer和producer2,多次刷新页面，可以看到“端口是9000”和“端口是9002”，来回跳动。说明ribbon集成了负载均衡
4.添加了hystrix的支持
5.添加hystrix的dashboard支持：
      浏览器打开，http://192.168.0.101:9001/hystrix，在页面中的地址输入框中输入http://192.168.0.101:9001/hystrix.stream,
      默认延迟，随便取个名称，就可以可视化的看到本服务的熔断情况
---------------------hystrix--------------------
1.工作原理：https://www.jianshu.com/p/e07661b9bae8
2.隔离，熔断，降级，缓存，监控展示
-------------------------------------------------
