package com.example.demo.chain;

public class Processor2 extends Handler {
    @Override
    public void handleRequest(String request) {
        if(request.equals("two")){
            System.out.println(" handler2 deal with it ");
        }else{
            if(getNext() != null){
                getNext().handleRequest(request);
            }else {
                System.out.println("no one gonna deal with it");
            }
        }
    }
}
