package JavaNotes.objectmapper;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

record Student(String name, Integer id, Marks marks) {
    @JsonCreator
    Student(
            @JsonProperty("name") String name,
            @JsonProperty("id") Integer id,
            @JsonProperty("marks") Marks marks
    ) {
        this.name = name;
        this.id = id;

        this.marks = marks;
    }
}
