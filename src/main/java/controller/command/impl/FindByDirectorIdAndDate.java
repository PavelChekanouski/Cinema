package controller.command.impl;

import controller.command.Command;
import entity.Film;
import services.DirectorService;
import services.FilmService;
import services.factory.ServiceFactory;
import services.factory.ServiceFactoryImpl;
import view.ConsolePrinter;
import view.ConsoleReader;

import java.sql.Date;

public class FindByDirectorIdAndDate implements Command {

    @Override
    public void execute() {
        ConsoleReader consoleReader = new ConsoleReader();
        String url = consoleReader.readURL();
        String user = consoleReader.readUsername();
        String password = consoleReader.readPassword();
        int director_id = Integer.parseInt(consoleReader.readDirector_id());
        Date release_date = Date.valueOf(consoleReader.readRelease_date());

        ServiceFactory serviceFactory = new ServiceFactoryImpl();

        FilmService filmService = serviceFactory.getService(FilmService.class);

        DirectorService directorService = serviceFactory.getService(DirectorService.class);

        ConsolePrinter consolePrinter = new ConsolePrinter();

        consolePrinter.printDirector(directorService.getDirectorById(url, user, password, director_id));
        for(Film film: filmService.getFilmsByDirectorIdAndDate(url, user, password, director_id, release_date)){
            consolePrinter.printFilm(film);
        }
    }
}
