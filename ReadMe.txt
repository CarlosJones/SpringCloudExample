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
2.http://192.168.0.100:9001/hello/lily，然后网页显示，hello lily，this is first messge
    说明调用成功