package repository;

import model.Actor;
import model.Director;
import model.Movie;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XMLprovider implements Provider {

    // metoda odczytu pliku XML oraz utworzenia obiektów JAVA i zapisanie ich w paimięci
    public void readFile(List<Movie> movies) {

        try {
            File fXmlFile = new File("src\\main\\resources\\files\\MoviesXML.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("movie"); //lista filmów

            for (int i = 0; i < nList.getLength(); i++)
            {
                //<movie> </movie>
                Node nNodeMovie = nList.item(i); //1 film

                Movie movie = new Movie();
                System.out.println("\nCurrent Element :" + nNodeMovie.getNodeName());

                if (nNodeMovie.getNodeType() == Node.ELEMENT_NODE)
                {

                    Element eElement = (Element) nNodeMovie; // teraz <movie> jest elementem

                    String title = eElement.getElementsByTagName("title").item(0).getTextContent();
                    System.out.println("Title : " + title);
                    movie.setTitle(title);

                    String directorFirstName = eElement.getElementsByTagName("firstName").item(0).getTextContent();
                    String directorLastName = eElement.getElementsByTagName("lastName").item(0).getTextContent();

                    Director director = new Director(directorFirstName, directorLastName);
                    System.out.println("model.Director : " + director.getFirstName() + " " + director.getLastName());
                    movie.setDirector(director);

                    String dateString = eElement.getElementsByTagName("dateOfProduction").item(0).getTextContent();

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate date = LocalDate.parse(dateString, formatter);

                    System.out.println("Date of production : " + date);
                    movie.setDateOfProduction(date);

                    String genre = eElement.getElementsByTagName("genre").item(0).getTextContent();
                    System.out.println("Genre : " + genre);
                    movie.setGenre(genre);

                    NodeList actorList = eElement.getElementsByTagName("actor");
                    List<Actor> actorsList = new ArrayList<Actor>();
                    for (int j = 0; j < actorList.getLength(); j++)
                    {
                        Node actorNode = actorList.item(j);
                        if (actorNode.getNodeType() == Node.ELEMENT_NODE)
                        {
                            Element actorElement = (Element) actorNode;
                            Actor actor = new Actor(actorElement.getElementsByTagName("firstName").item(0).getTextContent(), actorElement.getElementsByTagName("lastName").item(0).getTextContent());
                            System.out.println("Aktor : " + actor);
                            actorsList.add(actor);
                        }
                    }
                    movie.setListOfActors(actorsList);
                }
                movies.add(movie);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
