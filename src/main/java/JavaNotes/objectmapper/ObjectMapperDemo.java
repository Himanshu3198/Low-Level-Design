package JavaNotes.objectmapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;


public class ObjectMapperDemo {
    public static void main(String[] args) throws JsonProcessingException {

        String jsonString = """
                {
                    "name":"himanshu",
                        "id":21,
                        "marks":{
                          "physics":50.1,
                          "math": 61.2
                        }
                }""";

        ObjectMapper objectMapper = new ObjectMapper();

        Student student = objectMapper.readValue(jsonString,Student.class);
        System.out.println(student);
        Map<String,Object> studentMap = new HashMap<>();

        studentMap.put("name",student.name());
        studentMap.put("id",student.id());
        studentMap.put("marks",student.marks());

        System.out.println(studentMap);
        Marks marks  = (Marks) studentMap.get("marks");
        System.out.println(marks.math()+","+marks.physics());
    }

}


