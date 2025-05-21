package DistribuedJobScheduler.Factory;

import DistribuedJobScheduler.Job.ConcreteJob;
import DistribuedJobScheduler.Job.Job;

public class JobFactory {
    public static Job createSimpleJob(String name, Runnable runnable){
        return new ConcreteJob(name, (v)->runnable.run());
    }
}
