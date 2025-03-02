package JavaNotes;

import java.util.*;

class Props {
    int id;
    String name = "";

    public Props(int id, String name) {
        this.id = id;
        this.name = name;
    }

}

public class JavaSyntaxNotes {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 5, 6, 7, 8, 9, 10);
//        List<Integer> result = list.parallelStream().filter( i-> i%2==0).map(i->i*2).collect(Collectors.toList());
//        result.stream().forEach(System.out::println);
//        result.


//        reduce example

//        int sum = result.stream().reduce(0,(v1,v2)->v1+v2);
//        System.out.println("sum is: "+sum);

//        ************parallel streams*********************************************
//        System.out.println("In Normal");
//
//        // prints values from 1 to 5 (1 and 5 included)
//        IntStream r = IntStream.rangeClosed(1, 5);
//        r.forEach(System.out::println);
//
//        System.out.println("In Parallel");
//
//        // prints values from 1 to 5 (1 and 5 included)
//        IntStream r1 = IntStream.rangeClosed(1, 5);
//        r1.parallel().forEach(System.out::println);


//        String operation in java
        String s = "Hello I am Himanshu Sharma";
//        System.out.println(s.length());
//        System.out.println(s.substring(0,5));
        String[] lst = s.split(" ");
//        System.out.println(Arrays.toString(lst));

        String sR = "3198";
//        for(int i=0;i<sR.length();i++) {
//            System.out.println(sR.charAt(i));
//        }
        StringBuilder sB = new StringBuilder(sR);
//        sB.replace(0,'1',"42");
        sB.setCharAt(0, '4');
        sB.setCharAt(1, '5');

        sR = sB.toString();
//        System.out.println(sR);

        List<String> strLst = new ArrayList<>();
        strLst.add("abc");
        strLst.add("rust");
        strLst.add("brust");
        strLst.add("last");
        Collections.reverse(strLst);
//        strLst.sort((a,b)->a.length()>b.length());
//        for (int i=0;i <strLst.size(); i++) System.out.println(strLst.get(i));
//        System.out.println(strLst);
        Collections.sort(strLst, (a, b) -> Integer.compare(b.length(), a.length()));
//        System.out.println(strLst);

        Map<Integer, String> mp = new HashMap<>();
        mp.put(1, "himanshu");
        mp.put(2, "sharma");
//        System.out.println(mp.size());
        String val = mp.get(1);
//        System.out.println(val);
        val = mp.getOrDefault(1, "not found");
//        System.out.println(val);

//        if(mp.containsKey(1)) System.out.println(mp.get(1));
        for (Map.Entry<Integer, String> it : mp.entrySet()) {
//            System.out.println(it.getKey()+":"+it.getValue());

        }
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(2);
        nums.add(2);

//        ***** Map*************8
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            int curr = nums.get(i);

            int count = hash.getOrDefault(curr, 0);
            hash.put(curr, count + 1);

        }

        for (Map.Entry<Integer, Integer> itr : hash.entrySet()) {
//            System.out.println(itr.getKey()+":"+itr.getValue());
        }

        Set<Integer> st = new HashSet<>();
        st.addAll(nums);
//        System.out.println(st.size());
        if (st.contains(2)) System.out.println("yes it contains 2");
//        for (Integer i:st) System.out.println(i);
        Iterator<Integer> it = st.iterator();
//        while(it.hasNext()){
////            int currVal = it.next();
////            System.out.println(it.next());
//        }
//        Stack examples
        Stack<Integer> stk = new Stack<>();
        stk.push(24);
        stk.push(25);
        stk.push(30);
//        System.out.println(stk.size());
//        System.out.println(stk.isEmpty());
        while (!stk.isEmpty()) {
            System.out.println(stk.peek());
            stk.pop();
        }
        Queue<String> q = new LinkedList<>();
        q.add("himanshu");
        q.add("will");
        q.add("achieve");
//        System.out.println("Print Queue properties: ");
//        System.out.println(q.size());
//        while(!q.isEmpty()){
////            System.out.println(q.peek());
//            q.poll();
//        }
//        Priority Queue Min Heap
        System.out.println("print minHeap properties: ");
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(24);
        minHeap.add(4);
        minHeap.add(1);
        while (!minHeap.isEmpty()) {
            int curr = minHeap.peek();
//            System.out.println(curr);
            minHeap.poll();
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(24);
        maxHeap.add(4);
        maxHeap.add(1);
//        System.out.println("Print maxHeap : ");
//        System.out.println(maxHeap.size());
//        while (!maxHeap.isEmpty()) {
//            System.out.println(maxHeap.peek());
//            maxHeap.poll();
//        }


        List<Props> studentLst = new ArrayList<>();
        studentLst.add(new Props(1, "ramesh"));
        studentLst.add(new Props(3, "suresh"));
        studentLst.add(new Props(4, "kamlesh"));
        studentLst.add(new Props(10, "bhau"));
        System.out.println("print class with collections example");
        for (int i = 0; i < studentLst.size(); i++) {

            System.out.println(studentLst.get(i).id + "__" + studentLst.get(i).name);
        }

//        studentLst.sort((JavaNotes.Props a,JavaNotes.Props b)->Integer.compare(b.id,a.id));
        studentLst.sort((Props a, Props b)->Integer.compare(b.name.length(),a.name.length()));
        for (int i = 0; i < studentLst.size(); i++) {

            System.out.println(studentLst.get(i).id + "__" + studentLst.get(i).name);
        }


//   *********String to integer*************************
        String[]  strToNum =  {"12","4","26","331"};

        int sz = strToNum.length;
        int [] numFrmStr = new int[sz];

        for(int i=0; i<sz;i++){
            numFrmStr[i]= Integer.parseInt(strToNum[i]);
        }
        System.out.println(Arrays.toString(numFrmStr));

//   ********** integer to String *************

        int isz = numFrmStr.length;
        String[] bkToStr = new String[isz];
        for(int  i=0;i<isz;i++){
            bkToStr[i]=String.valueOf(numFrmStr[i]);
        }

        System.out.println("convert back to string");
        System.out.println(Arrays.toString(bkToStr));



    }

}
