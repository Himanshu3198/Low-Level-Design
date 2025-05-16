package DistribuedJobScheduler.Observer;

import DistribuedJobScheduler.Job.Job;

public interface JobObserver {
    void update(Job job);
}
