package JavaNotes.lambdaexpression;

import java.util.Arrays;
import java.util.List;
class Student{
    private String name;
    private int marks;

    public Student(String name,int marks){
        this.name = name;
        this.marks = marks;
    }

    public int getMarks(){
        return marks;
    }

    public String getName(){
        return name;
    }

    public Student setMarks(int marks){
        this.marks = marks;
        return this;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}
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
         * Sorting student by higher salary
         */

        List<Student> students = Arrays.asList(
                new Student("John", 5000),
                new Student("Alice", 7000),
                new Student("Bob", 3000)
        );

        students.sort((Student a,Student b)->a.getMarks()-b.getMarks());
        students.forEach(System.out::println);

        students.stream().map(s->s.setMarks(s.getMarks()/100)).forEach(System.out::println);

    }
}
