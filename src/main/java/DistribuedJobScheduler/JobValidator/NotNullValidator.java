package DistribuedJobScheduler.JobValidator;

import DistribuedJobScheduler.Job.Job;

public class NotNullValidator extends JobValidator{
    @Override
    protected boolean check(Job job) {
        boolean result = job != null;
        if(!result){
            System.out.println("Job is null");
            return false;
        }
        return true;
    }
}
