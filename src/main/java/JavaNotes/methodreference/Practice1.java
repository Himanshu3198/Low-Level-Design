package JavaNotes.methodreference;


import java.util.Arrays;
import java.util.List;

class Student {
    String name;
    Student(String name) {
        this.name = name;
    }
    public String toString() {
        return name;
    }
}
public class Practice1 {

    public static void printUpper(String s){
        System.out.println(s.toUpperCase());
    }


        public void print(String s){
            System.out.println("Hello "+s);
        }


    public static void main(String[] args) {

        /**
         * Syntax :
         * ClassName::staticMethod
         * object::instanceMethod
         * ClassName::instanceMethod
         * ClassName::new   // constructor reference
         */

        /**
         * Static Method reference
         */

        List<String> names = Arrays.asList("java", "python", "go");
        names.forEach(Practice1::printUpper);

        /**
         * Instance Method reference
         */
        List<String> people= Arrays.asList("Alice", "Bob", "Joe");

        Practice1 obj = new Practice1();

        people.forEach(obj::print);


        /**
         * Constructor reference
         */

        List<Student> students = people.stream().map(Student::new).toList();
        students.forEach(System.out::println);






    }
}
