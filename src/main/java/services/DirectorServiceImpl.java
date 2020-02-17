package services;

import dao.DirectorReader;
import entity.Director;

public class DirectorServiceImpl implements DirectorService {

    @Override
    public Director getDirectorById(String url, String user, String password, int id) {
        DirectorReader directorReader = new DirectorReader();
        return directorReader.getDirectorById(url, user, password, id);
    }
}
