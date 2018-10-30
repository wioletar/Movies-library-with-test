package repository;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Movie;

import java.io.*;
import java.util.*;

public class JSONprovider implements Provider {


    public void readFile(List<Movie> movies) throws IOException {

            Movie[] movies1;
            ArrayList<Movie> library;
            String path = "src\\main\\resources\\files\\MoviesJSON.json";
            File file = new File(path);
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            library = new ArrayList<Movie>(Arrays.asList(mapper.readValue(file, Movie[].class)));
            movies.addAll(library);
            System.out.println(" -> Wczytano "+library.size()+" filmów.");
        }
}
