package DistribuedJobScheduler.Strategy;

import DistribuedJobScheduler.Job.Job;

public interface SchedulingStrategy {
    void schedule(Runnable job);
}
