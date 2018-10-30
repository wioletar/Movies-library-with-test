package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import repository.Person;

public class Director extends Person {

    @JsonCreator
    public Director(@JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName) {
        super(firstName, lastName);
    }
}
