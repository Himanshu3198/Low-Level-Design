package DistribuedJobScheduler.Strategy;

import DistribuedJobScheduler.Job.Job;
import DistribuedJobScheduler.scheduler.JobScheduler;

public class ImmediateStrategy implements SchedulingStrategy{
    @Override
    public void schedule(Runnable job) {
        JobScheduler.getInstance().getExecutor().submit(job);
    }
}
