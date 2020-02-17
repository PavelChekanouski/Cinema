package dao;

import entity.Director;

import java.sql.*;

public class DirectorReader {
    public Director getDirectorById(String url, String user, String password, int id) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {

            System.out.println("Where is your PostgreSQL JDBC Driver? "
                    + "Include in your library path!");
            e.printStackTrace();
        }

        Director director = null;

        try (Connection connection = DriverManager.getConnection(
                url, user, password)) {
            String sql = "SELECT first_name, last_name, birth_date FROM Director WHERE id = ?";

            try(PreparedStatement statement = connection.prepareStatement(sql)){

                statement.setInt(1, id);

                try(ResultSet resultSet = statement.executeQuery()){

                    if(resultSet.next()){
                        director = new Director(id, resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getDate("birth_date"));
                        return director;
                    }

                }
            }
        } catch (SQLException e) {

            System.out.println("Connection with database Failed!");
            e.printStackTrace();
        }
        return director;
    }
}
