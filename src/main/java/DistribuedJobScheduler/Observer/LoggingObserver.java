package DistribuedJobScheduler.Observer;

import DistribuedJobScheduler.Job.Job;
import org.designPattern.observerPattern.Observer;

public class LoggingObserver implements JobObserver {
    @Override
    public void update(Job job) {
        System.out.println("JobName: "+job.getName()+" job state: "+job.getState().getStatus());
    }
}
