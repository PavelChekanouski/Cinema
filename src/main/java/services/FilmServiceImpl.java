package services;

import dao.FilmReader;
import entity.Film;

import java.sql.Date;
import java.util.List;

public class FilmServiceImpl implements FilmService {
    @Override
    public List<Film> getFilmsByDirectorId(String url, String user, String password, int id) {
        FilmReader filmReader = new FilmReader();
        return filmReader.getFilmsByDirectorId(url, user, password, id);
    }

    @Override
    public List<Film> getFilmsByDate(String url, String user, String password, Date date) {
        FilmReader filmReader = new FilmReader();
        return filmReader.getFilmsByDate(url, user, password, date);
    }

    @Override
    public List<Film> getFilmsByDirectorIdAndDate(String url, String user, String password, int id, Date date) {
        FilmReader filmReader = new FilmReader();
        return filmReader.getFilmsByDirectorIdAndDate(url, user, password, id, date);
    }
}
