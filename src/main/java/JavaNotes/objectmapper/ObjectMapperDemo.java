package JavaNotes.objectmapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;


public class ObjectMapperDemo {
    public static void main(String[] args) throws JsonProcessingException {

        String jsonString = "{\n" +
                "    \"name\":\"himanshu\",\n" +
                "        \"id\":21,\n" +
                "        \"marks\":{\n" +
                "          \"physics\":50.1,\n" +
                "          \"math\": 61.2\n" +
                "        }\n" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();

        Student student = objectMapper.readValue(jsonString,Student.class);
        System.out.println(student);
        Map<String,Object> studentMap = new HashMap<>();

        studentMap.put("name",student.getName());
        studentMap.put("id",student.getId());
        studentMap.put("marks",student.getMarks());

        System.out.println(studentMap);
        Marks marks  = (Marks) studentMap.get("marks");
        System.out.println(marks.getMath()+","+marks.getPhysics());
    }

}


