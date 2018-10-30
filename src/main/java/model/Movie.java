package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import repository.LocalDateDeserializer;
import repository.LocalDateSerializer;

import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import java.util.Objects;

public class Movie {

    private String title;
    private Director director;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dateOfProduction;

    private String genre;
    private List<Actor> listOfActors;

    public Movie() {
    }

    @JsonCreator
    public Movie(@JsonProperty("title") String title, @JsonProperty("director") Director director, @JsonProperty("dateOfProduction") LocalDate dateOfProduction, @JsonProperty("genre") String genre, @JsonProperty("listOfActors") List<Actor> listOfActors) {
        this.title = title;
        this.director = director;
        this.dateOfProduction = dateOfProduction;
        this.genre = genre;
        this.listOfActors = listOfActors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public LocalDate getDateOfProduction() {
        return dateOfProduction;
    }

    public void setDateOfProduction(LocalDate dateOfProduction) {
        this.dateOfProduction = dateOfProduction;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Actor> getListOfActors() {
        return listOfActors;
    }

    public void setListOfActors(List<Actor> listOfActors) {
        this.listOfActors = listOfActors;
    }

    @Override
    public String toString() {
        return title + '\'' + director + '\'' + dateOfProduction + '\'' + genre + '\'' + listOfActors;
    }


    @Override
    public boolean equals(Object obj) {
        Movie movie = (Movie) obj;
        boolean status = false;
        if (this.getTitle().equalsIgnoreCase(movie.getTitle())
                && this.getDateOfProduction().isEqual(movie.getDateOfProduction())
                && this.getDirector().equals(movie.getDirector())
                && this.getListOfActors().equals(movie.getListOfActors())
                && this.getGenre().equalsIgnoreCase(movie.getGenre())) {
            status = true;
        }
        return status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, director, dateOfProduction, genre, listOfActors);
    }
}
