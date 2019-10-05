package com.example.demo;

import com.example.demo.strategy.InspectionConstant;
import com.example.demo.strategy.InspectionSolver;
import com.example.demo.strategy.InspectionSolverChooser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private InspectionSolverChooser chooser;

    @Test
    public void test() throws Exception{
        String taskType = InspectionConstant.INSPECTION_TASK_TYPE_BATCH_CHANGE_WAREHOUSE;
        InspectionSolver  solver = chooser.choose(taskType);
        if(solver == null){
            throw new RuntimeException("not now");
        }

        solver.solve(11L, 22L);
    }

    @Test
    public void contextLoads() {

    }

}
