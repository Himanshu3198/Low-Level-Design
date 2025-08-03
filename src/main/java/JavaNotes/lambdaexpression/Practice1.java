package JavaNotes.lambdaexpression;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Practice1 {
    interface MyFunctionalInterface {
        void sayMessage(String msg);
    }

    public static void main(String[] args) {

        /**
         * lambda expression with function Interface
         */

        MyFunctionalInterface message = (msg) -> System.out.println("Message: " + msg);
        message.sayMessage("Hello Mimanshu");


        /**
         * Lambda expression with collection
         */

        List<String> names = Arrays.asList("John", "Alex", "Bob", "Steve");

//        names.sort((a, b) -> a.length() - b.length()); asc order
        names.sort((a,b)-> b.length()-a.length());  // desc order
        names.forEach(name-> System.out.println("hello "+name));


        /**
         * Lambda with streams
         * filter the even numbers from list and square them
         */

        List<Integer> numbers = Arrays.asList(2, 5, 8, 10, 15);
        List<Integer> result = numbers.stream().filter(n->n%2==0).map(n->n*n).collect(Collectors.toList());
        System.out.println(result);





    }

}
