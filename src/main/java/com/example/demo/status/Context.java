package com.example.demo.status;

public class Context {

    private State state;

    public Context(State state) {
        this.state = state;
    }

    public void Handle(){
        state.Handle(this);
    }
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
