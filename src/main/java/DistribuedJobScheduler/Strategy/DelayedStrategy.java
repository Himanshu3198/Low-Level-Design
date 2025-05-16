package DistribuedJobScheduler.Strategy;

import DistribuedJobScheduler.scheduler.JobScheduler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DelayedStrategy implements SchedulingStrategy{

    private final long delay;

    public DelayedStrategy(long delay){
        this.delay = delay;
    }
    @Override
    public void schedule(Runnable job) {

        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.schedule(()->{
            JobScheduler.getInstance().getExecutor().submit(job);
        },delay, TimeUnit.MILLISECONDS);

    }
}
