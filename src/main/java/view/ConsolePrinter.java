package view;

import entity.Director;
import entity.Film;

public class ConsolePrinter {
    public void printDirector(Director director) {
        System.out.println(director);
    }

    public void printFilm(Film film){
        System.out.println(film);
    }

    public void printError() {
        System.out.println("The command is incorrect. Please, choose another");
    }
}
