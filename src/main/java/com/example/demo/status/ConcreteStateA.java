package com.example.demo.status;

public class ConcreteStateA extends State {

    @Override
    public void Handle(Context context) {
        System.out.printf("current state A.");
        context.setState(new ConcreteStateB());
    }
}
