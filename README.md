# Sutils手册

-----------------------------------------------------------------------------------

小白的工具集合,目前是只有几个类在里面，后续慢慢更新。
鉴于本人还是小白，所以本项目属于自用项目，如果你喜欢也可以支持并使用哦

-----------------------------------------------------------------------------------

### 0.准备工作

可以通过下面的两步来完成配置。

**1.导包：**

//TODO：目前还是需要导入MavenUrl，等审核通过可以直接写下面的依赖

```xml
 compile 'cn.surine:Sutils:1.0.0'
```

**2.注册 或 配置:**

首先要区分哪种需要配置，哪种不需要，比如说需要上下文的Toast等，需要设置开发或正式环境的Log等，根据你的需要设置，每个工具类都会有各自的介绍，使用时，需得根据对应的说明进行使用，若需要Context的工具类无法取得Context，则会抛出异常，请关注[UtilsManager](https://github.com/Surine/Sutils/blob/master/sutils/src/main/java/cn/surine/sutils/UtilsManager.java)里的check方法

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



### 1. 工具包介绍

- Toasts

  ```java
  简介 ： 用于弹出Toast
  使用前需注册： Toasts.setContext(getBaseContext())，也可以不需要注册，而在使用者中传入context
  
  API：setContext  //设置上下文
       shortShow  //短暂显示（两种重载）
       longShow   //长时显示 （两种重载）
   
  使用示例： Toasts.shortShow("xxxx消息");
  
  ```

  

- SharedPres

  ```
  简介 ： 用于缓存储存
  使用前先注册：类名.setContext(getBaseContext())，也可以不需要注册，而在使用者中传入context
  
  API： setContext  //设置上下文
        setData   //设置数据 （两种重载）
        getData  //取得数据 （两种重载）
        findKey  //查找键是否存在（两种重载）
        clearData  //清除全部数据（两种重载）
        remove  //清除键值对（两种重载）
        
        
  使用示例：SharedPres.setData("tag","消息");
  
  ```


- Logs

  ```
  简介：日志打印
  使用时不需要注册，但是可以根据是否上线设置日志的显示与否
  Logs.setOpen(false); //false为生产环境，true为开发环境，默认为true
  
  API：setOpen  //设置日志开关
       setTag  //设置tag
       w，e,d,i,v //等日志级别方法重载
  
  使用示例：Logs.d("xxx消息");
  ```

- NetWorks

  ```
  简介：网络状态
  使用时候先注册：类名.setContext(getBaseContext());
  也可以不需要要注册，而在使用者中传入context
  
  API：
      setContext   //设置上下文
      isConnected  // 网络是否连接 true/false
      isWifiConnected  // 是否wifi连接 true/false
      getNetWorkStatus  // 返回连接状态码 int {1:wifi 2: mobile,3:no connect,4:other}
      getNetWorkStatusByAndroid  // 返回连接状态码（Android）：具体可查看ConnectivityManager内常量
  
  使用示例：NetWorks.getNetWorkStatus();
  
  ```

  
### 3. 版本

```
v1.0.0 更新日志
       新增Toasts，SharedPres，Logs，NetWorks
```       
       
### 4. 个人
 - 个人网站：https://surine.cn
 - 个人博客：https://blog.surine.cn
 - 简书：https://www.jianshu.com/u/5b0517615c4e


### 5. LICENSES
       Apache-2.0
