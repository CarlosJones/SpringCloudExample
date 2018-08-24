----------SpringCloudEureka--------------
1.简单的两个eureka相互注册的例子
2.在hosts文件中，修改
    127.0.0.1 peer1
    127.0.0.1 peer2
3.启动时报错，没有关系
4.http://peer2:8001查看启动情况
-----------SpringCloudProducer----------
将服务注册到peer2上，因为单机情况
-----------SpringCloudConsumer-----------
0.将服务注册到peer2上，因为单机情况
1.先启动SpringCloudProducer，然后启动SpringCloudConsumer
2.http://http://192.168.0.100:8764/hello?name=zhangsan，然后网页显示，hello zhangsan，这里是 SpringCloudProducer,端口是9000
    说明调用成功
-----------SpringCloudProducer2----------
1.producer的第二个实例，同一个服务，生成2个实例，只是端口号不同
------------SpringCloudRibbon------------
1.Ribbon是一个负载均衡客户端，可以很好的控制http和tcp的一些行为。
2.Feign默认集成了ribbon。
3.若同时启动producer和producer2,多次刷新页面，可以看到“端口是9000”和“端口是9002”，来回跳动。说明ribbon集成了负载均衡
----------SpringCloudHystrix----------
1.工作原理：https://www.jianshu.com/p/e07661b9bae8
2.隔离，熔断，降级，缓存，监控展示
3.
