import model.Actor;
import model.Director;
import model.Movie;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import repository.JSONprovider;
import repository.XMLprovider;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileToObjectReaderTest {


    private JSONprovider jsonReader;
    private XMLprovider xmlReader;


    @BeforeClass
    public void setUp() throws Exception {
        jsonReader = new JSONprovider();
        xmlReader = new XMLprovider();
    }

    @Test
    public void shouldReadJsonFile() throws IOException {
        Movie expectedMovie = new Movie("Kler", new Director("Wojciech", "Smarzowski"),
                LocalDate.of(2018,9,28),
                "Obyczajowy", Arrays.asList(new Actor("Arkadiusz", "Jakubik"), new Actor("Robert","Węckiewicz" ), new Actor("Jacek","Braciak"), new Actor("Janusz","Gajos")));

       // JSONprovider.readFile(List<Movie>movies);
        ArrayList<Movie> library= new ArrayList<Movie>();

        jsonReader.readFile(library);

        Assert.assertEquals(library.size(),6);
        Assert.assertEquals(library.get(0), expectedMovie);

    }

    @AfterMethod
    public void teadDown(){
        System.out.println(jsonReader);
    }

//    @Test
//    public void shouldReadXmlFile(){
//
//    }

}
