package JavaNotes.practice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileReadImpl {
    public static void main(String[] args) {

        String filePath = "src/main/resources/SampleData.txt";

        ArrayList<String> s = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){

            String line;
            while((line = br.readLine()) != null){
                s.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);

        }
        System.out.println(s.size());
        for(String t:s){
            for(int i=0;i<t.length();i++){
//                use of charAt
//                System.out.println(t.charAt(i));
//                substring
//                System.out.println(t.substring(0,2));
            }
//            System.out.println("****new line*******");
        }
        String [] m = null;
        for(String t:s){
            m = t.split(" ");
        }

        assert m != null;
        System.out.println(m.length);
        for(int i=0;i<m.length;i++){
            System.out.println(m[i]);
        }

        for(int i=0;i<m.length;i++){
            StringBuilder sb  = new StringBuilder(m[i]);
            for(int j=0;j<m[i].length();j++){

                sb.setCharAt(j,'$');
            }
            String k = sb.toString();
            System.out.println(k);
        }
    }
}
