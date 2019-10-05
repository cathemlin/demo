package com.example.demo.chain;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

public class ChainProcessor implements ApplicationContextAware {


    private List<String> processorList;

    private static ApplicationContext context;
    private static Map<String, Handler> processorMap;
    private Handler last;


    public void execute (List<String> processorList, String request){

        for (int i = processorList.size() - 1; i >= 0; i--) {
            String name = processorList.get(i);
            final Handler handler = processorMap.get(name);
            if(last == null){
                last = handler;
            }else {
                 handler.setNext(last);
                 last = handler;
            }
        }

        last.handleRequest(request);
    }



    @PostConstruct
    public void initProcessor(){
        processorMap = context.getBeansOfType(Handler.class);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
