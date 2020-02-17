package services;

import entity.Film;

import java.sql.Date;
import java.util.List;

public interface FilmService extends Service{
    List<Film> getFilmsByDirectorId(String url, String user, String password, int id);
    List<Film> getFilmsByDate(String url, String user, String password, Date date);
    List<Film> getFilmsByDirectorIdAndDate(String url, String user, String password, int id, Date date);
}
