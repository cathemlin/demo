package com.example.demo.proxy;

public class ClientTestHandler {
    public static void main(String[] args) {
        DynamicHandler dynamicHandler = new DynamicHandler();
        Subject subject = (Subject) dynamicHandler.newProxyInstance(new RealSubject());
        subject.request();
    }
}
