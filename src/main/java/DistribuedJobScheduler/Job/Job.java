package DistribuedJobScheduler.Job;

import DistribuedJobScheduler.state.JobState;

public interface Job {
    void execute();
    void setState(JobState jobState);
    JobState getState();
    String getName();

}
