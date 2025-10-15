package JavaNotes.objectmapper;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

class Student {
    private final String name;
    private final Integer id;
    private final Marks marks;

    @JsonCreator
    public Student(
            @JsonProperty("name") String name,
            @JsonProperty("id") Integer id,
            @JsonProperty("marks") Marks marks
    ) {
        this.name = name;
        this.id = id;
        this.marks = marks;
    }

    public String getName() { return name; }
    public Integer getId() { return id; }
    public Marks getMarks() { return marks; }
}
