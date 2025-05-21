package DistribuedJobScheduler;

import DistribuedJobScheduler.Builder.JobBuilder;
import DistribuedJobScheduler.Factory.JobFactory;
import DistribuedJobScheduler.Job.Job;
import DistribuedJobScheduler.JobValidator.JobNameValidator;
import DistribuedJobScheduler.JobValidator.JobValidator;
import DistribuedJobScheduler.JobValidator.NotNullValidator;
import DistribuedJobScheduler.Observer.LoggingObserver;
import DistribuedJobScheduler.Strategy.DelayedStrategy;
import DistribuedJobScheduler.Strategy.ImmediateStrategy;
import DistribuedJobScheduler.scheduler.JobScheduler;

public class JobSchedulerSystem {

    public static void main(String[] args) {
        JobScheduler scheduler = JobScheduler.getInstance();

        scheduler.registerObserver(new LoggingObserver());

        JobValidator validatorChain = new NotNullValidator().linkWith(new JobNameValidator());

        Job job1 = JobFactory.createSimpleJob("Email Job",()->System.out.println("Sending emails"));

        if(validatorChain.validate(job1)){
            scheduler.schedule(job1,new ImmediateStrategy());
        }

        Job delayedJob = new JobBuilder().setName("Delayed job").setTask((v)->System.out.println("Delayed task..")).build();
        if(validatorChain.validate(delayedJob)){
            scheduler.schedule(delayedJob, new DelayedStrategy(20000));
        }
    }
}
