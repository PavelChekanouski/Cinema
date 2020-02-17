package dao;

import entity.Director;
import entity.Film;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmReader {

    public List<Film> getFilmsByDirectorId(String url, String user, String password, int director_id)  {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {

            System.out.println("Where is your PostgreSQL JDBC Driver? "
                    + "Include in your library path!");
            e.printStackTrace();
        }

        List<Film> films = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            String sql = "SELECT id, name, release_date, genre FROM Film WHERE director_id = ?";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setInt(1, director_id);

                try (ResultSet resultSet = statement.executeQuery()) {
                    Film film = null;
                    Director director = new Director();
                    director.setId(director_id);

                    while (resultSet.next()) {

                        film = new Film(resultSet.getInt("id"), director_id, resultSet.getString("name"), resultSet.getDate("release_date"), resultSet.getString("genre"));
                        films.add(film);
                    }

                }
            }

        } catch (SQLException e) {

            System.out.println("Connection with database Failed!");
            e.printStackTrace();
        }
        return films;
    }

    public List<Film> getFilmsByDate(String url, String user, String password, Date date) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {

            System.out.println("Where is your PostgreSQL JDBC Driver? "
                    + "Include in your library path!");
            e.printStackTrace();
        }

        List<Film> films = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(
                url, user, password)) {

            String sql = "SELECT id, director_id, name, genre FROM Film WHERE release_date >= ?";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setDate(1, date);

                try (ResultSet resultSet = statement.executeQuery()) {
                    Film film = null;

                    while (resultSet.next()) {
                        film = new Film(resultSet.getInt("id"), resultSet.getInt("director_id"), resultSet.getString("name"), date, resultSet.getString("genre"));
                        films.add(film);
                    }
                }
            }

        } catch (SQLException e) {

            System.out.println("Connection with database Failed!");
            e.printStackTrace();
        }
        return films;
    }

    public List<Film> getFilmsByDirectorIdAndDate(String url, String user, String password, int director_id, Date date) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {

            System.out.println("Where is your PostgreSQL JDBC Driver? "
                    + "Include in your library path!");
            e.printStackTrace();
        }

        List<Film> films = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(
                url, user, password)) {

            String sql = "SELECT id, name, release_date, genre FROM Film WHERE release_date >= ? AND director_id = ? ";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setDate(1, date);
                statement.setInt(2, director_id);

                try (ResultSet resultSet = statement.executeQuery()) {
                    Film film = null;

                    while (resultSet.next()) {

                        film = new Film(resultSet.getInt("id"), director_id, resultSet.getString("name"), resultSet.getDate("release_date"), resultSet.getString("genre"));
                        films.add(film);
                    }

                }
            }

        } catch (SQLException e) {

            System.out.println("Connection with database Failed!");
            e.printStackTrace();
        }
        return films;
    }
}