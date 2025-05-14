package DistribuedJobScheduler.state;

public class FailedState implements JobState {

    @Override
    public String getStatus() {
        return "FailedState";
    }
}
