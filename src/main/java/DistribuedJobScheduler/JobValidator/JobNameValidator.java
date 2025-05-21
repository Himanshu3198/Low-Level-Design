package DistribuedJobScheduler.JobValidator;

import DistribuedJobScheduler.Job.Job;

public class JobNameValidator extends JobValidator{
    @Override
    protected boolean check(Job job) {
         boolean result = job.getName()!=null && !job.getName().isEmpty();
         if(!result) {
             System.out.println("Invalid Job Name");
             return false;
         }
         return true;
    }
}
