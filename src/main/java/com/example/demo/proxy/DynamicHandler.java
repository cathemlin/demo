package com.example.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicHandler implements InvocationHandler {
    private Object targetObject;



    public Object newProxyInstance(Object targetObject) {
        this.targetObject = targetObject;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(), this);

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(">>>>>>>>>>>>>>before invoke");
        method.invoke(targetObject, args);
        System.out.println(">>>>>>>>>>>>>>after invoke");
        return null;
    }
}
