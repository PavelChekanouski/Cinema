package services;

import entity.Director;

public interface DirectorService extends Service {
    Director getDirectorById(String url, String user, String password, int id);
}
