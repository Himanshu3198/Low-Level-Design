package DistribuedJobScheduler.JobValidator;

import DistribuedJobScheduler.Job.Job;

public abstract class JobValidator {

    protected JobValidator next;

    public JobValidator linkWith(JobValidator next){
        this.next = next;
        return next;
    }

    public boolean validate(Job job){
        if(!check(job)) return false;
        return next == null || next.validate(job);
    }
    protected abstract boolean check(Job job);
}
