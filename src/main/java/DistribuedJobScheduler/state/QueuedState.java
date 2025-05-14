package DistribuedJobScheduler.state;

public class QueuedState implements JobState{
    @Override
    public String getStatus() {
        return "QueuedState";
    }
}
