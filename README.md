# zuul-eureka-demo
zuul+eureka的demo，里面包含三个基本的service，实现了基本的转发url的功能

用的时候吧service-demo对应的filter里的Component注解注释去掉即可，把其他的filter注释掉，不然相互影响的

20181029

作者：GYB

简书介绍此项目地址：https://www.jianshu.com/p/3083d6f4f231

我也是第一次用springcloud的微服务框架
这三个项目是由启动顺序的（说明项目大做了呀）

1 先启动Eureka服务，不然其他服务先启动的话，会去注册中心找服务

2 再启动service业务服务

3 启动zuul转发器服务
# zuul-eureka-demo1# zuul-eureka-demo
zuul+eureka的demo，里面包含三个基本的service，实现了基本的转发url的功能

用的时候吧service-demo对应的filter里的Component注解注释去掉即可，把其他的filter注释掉，不然相互影响的

20181029

作者：GYB

简书介绍此项目地址：https://www.jianshu.com/p/3083d6f4f231

我也是第一次用springcloud的微服务框架
这三个项目是由启动顺序的（说明项目大做了呀）

1 先启动Eureka服务，不然其他服务先启动的话，会去注册中心找服务

2 再启动service业务服务

3 启动zuul转发器服务
