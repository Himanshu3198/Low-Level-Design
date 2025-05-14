package DistribuedJobScheduler.state;

public class CompleteState implements JobState{
    @Override
    public String getStatus() {
        return "CompleteState!";
    }
}
