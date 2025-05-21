package DistribuedJobScheduler.Builder;


import DistribuedJobScheduler.Job.ConcreteJob;

import java.util.function.Consumer;

public class JobBuilder {

    private String name;
    Consumer<Void> task;

    public JobBuilder setName(String name){
        this.name = name;
        return this;
    }

    public JobBuilder setTask(Consumer<Void>task){
        this.task = task;
        return this;
    }

    public ConcreteJob build(){
        return new ConcreteJob(name,task);
    }



}
