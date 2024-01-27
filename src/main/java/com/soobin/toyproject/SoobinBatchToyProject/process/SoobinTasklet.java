package com.soobin.toyproject.SoobinBatchToyProject.process;

import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

//@Component
public class SoobinTasklet implements TaskExecutor {

    @Override
    public void execute(Runnable task) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>> Tasklet");

//        task.run();
    }
}