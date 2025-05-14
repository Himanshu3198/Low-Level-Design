package DistribuedJobScheduler.state;

public class RunningState implements JobState{
    @Override
    public String getStatus() {
        return "RunningState..";
    }
}
