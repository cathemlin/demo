package com.example.demo.strategy;

public abstract class InspectionSolver {
    public abstract void solve(Long orderId, Long userId);

    public abstract String[] supports();
}
