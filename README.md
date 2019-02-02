# Sutils手册

小白的工具集合

### 0.准备工作



**导包：**

```xml
 compile 'cn.surine:Sutils:1.0.0'
```

**注册 及 配置:**

首先要区分哪种需要配置，那种不需要，比如说需要上下文的Toast等，需要设置开发及正式环境的Log等，根据你的需要设置，每个工具类都会有各自的介绍，使用时，需得根据对应的步骤进行使用。

但是对于设置上下文的工具类，有两种方式

第一种可以一下子全部设置

```java
 //初始化工具包
  UtilsManager.initContext(getBaseContext());
```

这个方法可以配置工具包中的所有工具类的上下文，一劳永逸。

当然你也可以单独设置，举例：

```java
Toasts.setContext(getBaseContext());
```

或者单独配置logs工具的关闭

```java
Logs.setOpen(false);
```

这只是简短的介绍，推荐第一种方法。



### 1. 工具包

- Toasts

  ```java
  简介 ： 用于弹出Toast
  使用前需注册： Toasts.setContext(getBaseContext());
  也可以不需要注册，而在使用者中传入context
  
  使用示例： Toasts.shortShow("xxxx消息");
  
  ```

  

- SharedPres

  ```
  简介 ： 用于缓存储存
  使用前先注册：类名.setContext(getBaseContext());
  也可以不需要注册，而在使用者中传入context
  
  使用示例：SharedPres.setData("tag","消息");
  
  ```


- Logs

  ```
  简介：日志打印
  使用时不需要注册，但是可以根据是否上线设置日志的显示与否
  Logs.setOpen(false); //false为生产环境，true为开发环境，默认为true
  
  使用示例：Logs.d("xxx消息");
  ```

- NetWorks

  ```
  简介：网络状态
  使用时候先注册：类名.setContext(getBaseContext());
  也可以不需要要注册，而在使用者中传入context
  
  包含方法：
       网络是否连接 true/false
       是否wifi连接 true/false
       返回连接状态码 int {1:wifi 2: mobile,3:no connect,4:other}
       返回连接状态码（Android）：具体可查看ConnectivityManager内常量
  
  使用示例：NetWorks.getNetWorkStatus();
  
  ```

  
