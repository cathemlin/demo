package com.example.demo.chain;


import org.springframework.stereotype.Component;

@Component
public class Processor1 extends  Handler{


    @Override
    public void handleRequest(String request) {
        if(request.equals("one")){
            System.out.println(" handler1 deal with it ");
        }else{
            if(getNext() != null){
                getNext().handleRequest(request);
            }else {
                System.out.println("no one gonna deal with it");
            }
        }
    }
}
