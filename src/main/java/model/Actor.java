package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import repository.Person;

public class Actor extends Person {

    @JsonCreator
    public Actor(@JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName) {
        super(firstName, lastName);
    }
}
