package com.example.demo.strategy;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class InspectionSolverChooser implements ApplicationContextAware {
    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
        System.out.println("start ApplicationContextAware listener");
    }

    private ConcurrentHashMap<String, InspectionSolver> chooseMap = new ConcurrentHashMap<>();

    public InspectionSolver choose(String type){
        return chooseMap.get(type);
    }

    @PostConstruct
    public void register(){
        System.out.println("start register----------");
        Map<String, InspectionSolver> solverMap =
                context.getBeansOfType(InspectionSolver.class);

        for (InspectionSolver solver : solverMap.values()) {
            for (String support : solver.supports()) {
                chooseMap.putIfAbsent(support, solver);
            }
        }
    }

}
