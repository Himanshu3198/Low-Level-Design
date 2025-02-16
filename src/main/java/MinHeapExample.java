import java.util.Comparator;
import java.util.PriorityQueue;

public class MinHeapExample {


    private static class PairModel{
          int time ;
          int id;
          public PairModel(int time, int id){
              this.time = time;
              this.id = id;
          }
    }
    private  static class PairComparator implements Comparator<PairModel>{
        @Override
        public  int compare(PairModel a,PairModel b){
            return Integer.compare(a.time, b.time);
        }
    }

    public static void main(String[] args) {

         PriorityQueue<PairModel> minHeap = new PriorityQueue<>(new PairComparator());
         minHeap.add(new PairModel(1,10));
         minHeap.add(new PairModel(20,55));
         minHeap.add(new PairModel(5,65));

         while(!minHeap.isEmpty()){
             PairModel curr = minHeap.poll();
             System.out.println(curr.time+","+curr.id);
         }

    }
}
