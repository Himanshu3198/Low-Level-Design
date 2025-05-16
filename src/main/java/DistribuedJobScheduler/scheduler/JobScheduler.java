package DistribuedJobScheduler.scheduler;

import DistribuedJobScheduler.Job.Job;
import DistribuedJobScheduler.Observer.JobObserver;
import DistribuedJobScheduler.Strategy.SchedulingStrategy;
import DistribuedJobScheduler.state.CompleteState;
import DistribuedJobScheduler.state.FailedState;
import DistribuedJobScheduler.state.RunningState;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JobScheduler {

    private static final JobScheduler instance = new JobScheduler();
    private final List<JobObserver> observerList = new ArrayList<>();
    private final ExecutorService executor = Executors.newFixedThreadPool(5);

    private JobScheduler(){}

    public static JobScheduler getInstance(){
        return instance;
    }
    public void schedule(Job job, SchedulingStrategy strategy){
        try {
            strategy.schedule(()->executeJob(job));
        }catch (Exception e){
            System.out.println("Failed to scheduled: "+e.getMessage());
        }

    }

    public void executeJob(Job job){
        try{
            job.setState(new RunningState());
            job.execute();
            job.setState(new CompleteState());

        }catch (Exception e){
            job.setState(new FailedState());
            System.out.println(e.getMessage());

        }finally {
            notifyObserver(job);
        }
    }

    public void registerObserver(JobObserver observer){
        observerList.add(observer);
    }

    public void notifyObserver(Job job){
        observerList.forEach(obs->obs.update(job));
    }
    public void shutDown(){
        executor.shutdown();
    }
    public ExecutorService getExecutor(){
        return executor;
    }
}
