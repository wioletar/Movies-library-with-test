package repository;

public enum MovieMenu {
    Z("Continue"),
    A("wczytaj plik XML"),
    B("wczytaj plik JSON"),
    C("wyszukanie filmu po gatunku"),
    D("wyszukiwanie filmu po nazwisku aktora"),
    E("wyszukiwanie filmu po dacie"),
    F("wypisz filmy z pamięci"),
    G("wyjście");

    private String meaning;


    MovieMenu(String meaning) {
        this.meaning = meaning;
    }

    public String getMeaning() {
        return meaning;
    }

}