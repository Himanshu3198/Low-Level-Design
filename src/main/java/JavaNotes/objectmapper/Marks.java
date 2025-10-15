package JavaNotes.objectmapper;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

class Marks {
    private final Float physics;
    private final Float math;

    @JsonCreator
    public Marks(
            @JsonProperty("physics") Float physics,
            @JsonProperty("math") Float math
    ) {
        this.physics = physics;
        this.math = math;
    }

    public Float getPhysics() { return physics; }
    public Float getMath() { return math; }
}
