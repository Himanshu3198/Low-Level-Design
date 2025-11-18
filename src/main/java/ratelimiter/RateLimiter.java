package ratelimiter;


import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

class FixedWindowLog{

    private final Integer maxRequest;
    private final long windowSize;

    private AtomicInteger requestCount;
    private long windowStart;




    public FixedWindowLog(Integer maxRequest, long windowSize){
        this.maxRequest = maxRequest;
        this.windowSize = windowSize;
        this.windowStart = System.currentTimeMillis();
        this.requestCount = new AtomicInteger(0);
    }

    public synchronized boolean allowRequest(int i){

        // reset time if time exceed the  relaxation time
        long now = System.currentTimeMillis();
        if(now - windowStart >= windowSize){
            windowStart = now;
            requestCount.set(0);
        }

        if(requestCount.getAndIncrement() <= maxRequest){
            System.out.println("ALLOWED Request="+i);
        }else{
            System.out.println("BLOCKED Request="+i);
            return false;
        }

        return true;
    }
}
class SlidingWindowLog{

    private final Integer maxRequests;
    private final long windowSize;
    private Deque<Long> timestamps;

    public SlidingWindowLog(Integer maxRequests, long windowSize){
        this.maxRequests = maxRequests;
        this.windowSize = windowSize;
        this.timestamps = new LinkedList<>();
    }

    public boolean allowRequest(int i){

        long now = System.currentTimeMillis();
        while(!timestamps.isEmpty() && now-timestamps.peekFirst() >= windowSize){  // remove the older entries
            timestamps.pollFirst();
        }

        if(timestamps.size() <= maxRequests){
            timestamps.addLast(now);
            System.out.println("ALLOWED Request="+i);
            return true;
        }
        System.out.println("BLOCKED Request="+i);
        return false;
    }
}

public class RateLimiter {

    public static void main(String[] args) throws InterruptedException {

//        runFixedWindowLog();
        runSlidingWindowLog();
    }

    private static void runFixedWindowLog() throws InterruptedException {
        FixedWindowLog  fixedWindowLog = new FixedWindowLog(5,10_000);
        for(int i=0;i<10;i++){
            if(fixedWindowLog.allowRequest(i)){
                System.out.println("[INFO] PASSED");
            }else{
                System.out.println("[ERROR] FAILED");
            }
            Thread.sleep(1000);
        }
        System.out.println("[INFO] Wait until Window Reset");
        Thread.sleep(4_000);
        for(int i=0;i<=3;i++){
            if(fixedWindowLog.allowRequest(i)){
                System.out.println("[INFO] PASSED");
            }else{
                System.out.println("[ERROR] FAILED");
            }
            Thread.sleep(1000);
        }
    }

    private static void runSlidingWindowLog() throws InterruptedException {
        SlidingWindowLog  fixedWindowLog = new SlidingWindowLog(5,1_0000);
        for(int i=0;i<10;i++){
            if(fixedWindowLog.allowRequest(i)){
                System.out.println("[INFO] PASSED");
            }else{
                System.out.println("[ERROR] FAILED");
            }
            Thread.sleep(1000);
        }
        System.out.println("[INFO] Wait until Window Reset");
        Thread.sleep(4_000);
        for(int i=0;i<=3;i++){
            if(fixedWindowLog.allowRequest(i)){
                System.out.println("[INFO] PASSED");
            }else{
                System.out.println("[ERROR] FAILED");
            }
            Thread.sleep(1000);
        }
    }

}
