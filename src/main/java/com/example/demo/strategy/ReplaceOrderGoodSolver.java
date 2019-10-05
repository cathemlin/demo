package com.example.demo.strategy;

import org.springframework.stereotype.Component;

@Component
public class ReplaceOrderGoodSolver extends InspectionSolver {

    @Override
    public void solve(Long orderId, Long userId) {
        System.out.println("starint replace orderId="+orderId);
    }

    @Override
    public String[] supports() {
        return new String[] { InspectionConstant.INSPECTION_TASK_TYPE_BATCH_REPLACE_ORDER_GOODS};
    }
}
