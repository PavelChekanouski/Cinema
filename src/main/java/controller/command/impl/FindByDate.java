package controller.command.impl;

import controller.command.Command;
import entity.Film;
import services.*;
import services.factory.ServiceFactory;
import services.factory.ServiceFactoryImpl;
import view.ConsolePrinter;
import view.ConsoleReader;

import java.sql.Date;

public class FindByDate implements Command {

    @Override
    public void execute() {
        ConsoleReader consoleReader = new ConsoleReader();
        String url = consoleReader.readURL();
        String user = consoleReader.readUsername();
        String password = consoleReader.readPassword();
        Date release_date = Date.valueOf(consoleReader.readRelease_date());
        ServiceFactory serviceFactory = new ServiceFactoryImpl();

        FilmService filmService = serviceFactory.getService(FilmService.class);

        DirectorService directorService = serviceFactory.getService(DirectorService.class);

        ConsolePrinter consolePrinter = new ConsolePrinter();

        for(Film film: filmService.getFilmsByDate(url, user, password, release_date)){
            consolePrinter.printDirector(directorService.getDirectorById(url, user, password, film.getDirector_id()));
            consolePrinter.printFilm(film);
        }
    }
}
