package repository;

import model.Movie;

import java.util.List;

public interface Provider {

    void readFile(List<Movie> movies) throws Exception;

}
