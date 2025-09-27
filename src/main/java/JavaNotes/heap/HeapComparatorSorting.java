package JavaNotes.heap;

import java.util.PriorityQueue;

class Comp implements Comparable<Comp>{

    private int jobId;
    private int priority;

    public Comp(int jobId, int priority){
        this.jobId = jobId;
        this.priority = priority;
    }

    public int getJobId() {
        return jobId;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Comp other){
        if(this.priority != other.priority){
            return Integer.compare(other.priority,this.priority);
        }
        return Integer.compare(other.jobId,this.jobId);
    }
}
public class HeapComparatorSorting {

    public static void main(String[] args) {
        PriorityQueue<Comp> maxHeap = new PriorityQueue<>();
        maxHeap.add(new Comp(1,5));
        maxHeap.add(new Comp(2,15));
        maxHeap.add(new Comp(5,20));

        while(!maxHeap.isEmpty()){
            System.out.println(maxHeap.poll().getJobId());
        }
    }


}
