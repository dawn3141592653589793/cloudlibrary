package com.printer.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK代理类
 */
public class MyProxy implements InvocationHandler {
    //声明目标类接口
    private UserDao userDao;
    //代理方法
    public Object createProxy(UserDao userDao){
        this.userDao=userDao;
        //1,类加载器
        ClassLoader classLoader = MyProxy.class.getClassLoader();
        //2，被代理对象的所有接口
        Class[] classes = userDao.getClass().getInterfaces();
        //3，使用代理类进行增强，返回代理参数
        return Proxy.newProxyInstance(classLoader,classes,this);
    }
    /**
     * 所有动态代理类的方法调用，都交给invoke()处理
     */
    public Object invoke(Object proxy, Method method,Object[] args) throws Throwable{
        //创建切面对象
        MyAspect myAspect =new MyAspect();
        //前增强
        myAspect.check_Permissions();
        //在目标类上调用方法
        Object obj=method.invoke(userDao,args);
        //后增强
        myAspect.log();
        return obj;
    }
}
