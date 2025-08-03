package JavaNotes.foreach;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Practice1 {

    public static void main(String[] args) {

        /**
         * 2d array iteration
         */
        int[][] matrix = {
                {10, 20},
                {30, 40},
                {50, 60}
        };

        Arrays.stream(matrix).forEach(row-> {
            Arrays.stream(row).forEach(System.out::print);
            System.out.println();
        });

        /**
         * Iterate over Map
         */

        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"java");
        map.put(2,"python");
        map.put(3,"go");

        map.forEach((key,value)->System.out.println(key+","+value));
        map.keySet().forEach(System.out::println);
        map.values().forEach(System.out::println);

        /**
         * forEach with streams
         */
        List<String> names = Arrays.asList("java", "python", "go");

        names.stream().map(String::toUpperCase).forEach(System.out::println);  // using method reference
        names.stream().map(s->s.toUpperCase()).forEach(s-> System.out.println(s));

    }
}
