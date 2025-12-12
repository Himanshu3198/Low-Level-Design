package JavaNotes.objectmapper;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

record Marks(Float physics, Float math) {
    @JsonCreator
    Marks(
            @JsonProperty("physics") Float physics,
            @JsonProperty("math") Float math
    ) {
        this.physics = physics;
        this.math = math;
    }
}
