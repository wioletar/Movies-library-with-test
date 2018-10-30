package controller;

import model.Director;
import model.Movie;
import repository.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class Main {

     public static void main(String[] args) throws IOException, Exception {
         SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
         Date date = dateFormat.parse("31/05/2011");

         System.out.println(dateFormat.format(date));

       //  Movie movie2 = new Movie("title",new Director("jan","kowalski"), );
        Provider provider;
        Scanner scanner = new Scanner(System.in);
        List<Movie> movies = new ArrayList<Movie>();
        MovieMenu movieMenu = MovieMenu.Z;
        while (movieMenu != MovieMenu.G) {
            readMenu();
            movieMenu = MovieMenu.valueOf(scanner.next());
            switch (movieMenu) {
                case Z:
                    break;
                case A:
                    provider=new XMLprovider();
                    provider.readFile(movies);
                    break;
                case B:
                    provider=new JSONprovider();
                    provider.readFile(movies);
                    break;
                case C:
                    MenuOptions.genreSearch(movies);
                    break;
                case D:
                    MenuOptions.actorSearch(movies);
                    break;
                case E:
                    MenuOptions.dateSearch(movies);
                    break;
                case F:
                    MenuOptions.moviesPrint(movies);
                    break;
                case G:
                    return;
                default:
                    System.out.println("Podano nieprawidłową wartość z menu");
                    break;
            }
        }
    }

    public static void readMenu() {
        System.out.println("\n");
        System.out.println("Movie Menu:");
        System.out.println("A-wczytaj plik XML");
        System.out.println("B-wczytaj plik JSON");
        System.out.println("C-wyszukanie filmu po gatunku");
        System.out.println("D-wyszukiwanie filmu po nazwisku aktora");
        System.out.println("E-wyszukiwanie filmu po dacie");
        System.out.println("F-wypisz filmy z pamięci");
        System.out.println("G-wyjście");
        System.out.println("Podaj literę z menu ");
    }
}
