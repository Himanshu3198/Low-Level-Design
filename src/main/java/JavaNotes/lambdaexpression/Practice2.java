package JavaNotes.lambdaexpression;

import java.util.Arrays;
import java.util.List;

public class Practice2 {

    interface  Calculator{
        void  calculate(int a,int b);
    }
    public static void main(String[] args) {

        /**
         * Sum of two numbers using lambda expression
         */

        Calculator compute = (int a,int b)-> System.out.println(a+b);
        compute.calculate(5,10);


        /**
         * String length >3
         */

        List<String> words = Arrays.asList("hi", "hello", "cat", "doggy");

        words.stream().filter(word->word.length()>3).forEach(System.out::println);


        /**
         * Sorting employee by higher salary
         */




    }
}
