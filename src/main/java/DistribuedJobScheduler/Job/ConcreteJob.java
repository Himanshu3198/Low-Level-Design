package DistribuedJobScheduler.Job;

import DistribuedJobScheduler.state.JobState;
import DistribuedJobScheduler.state.QueuedState;

import java.util.function.Consumer;

public class ConcreteJob implements Job{

    private final String name;
    private final Consumer<Void> task;
    private JobState jobState;

    public ConcreteJob(String name, Consumer<Void> task){
        this.name = name;
        this.task = task;
        this.jobState = new QueuedState();
    }

    @Override
    public void execute() {
       task.accept(null);
    }

    @Override
    public void setState(JobState jobState) {
           this.jobState = jobState;
    }

    @Override
    public JobState getState() {
        return jobState;
    }

    @Override
    public String getName() {
        return name;
    }

}
