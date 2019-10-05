package com.example.demo.status;

public class ConcreteStateB extends State {

    @Override
    public void Handle(Context context) {
        System.out.println("now state B.");
        context.setState(new ConcreteStateA());
    }
}
