package entity;

import java.util.Date;

public class Film {
    private int id;
    private int director_id;
    private String name;
    private Date release_date;
    private String genre;

    public Film(int id, int director_id, String name, Date release_date, String genre) {
        this.id = id;
        this.director_id = director_id;
        this.name = name;
        this.release_date = release_date;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDirector_id() {
        return director_id;
    }

    public void setDirector_id(int director_id) {
        this.director_id = director_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Film{" +
                " name = " + name + '\'' +
                ", release_date = " + release_date +
                ", genre = " + genre + '\'' +
                '}';
    }
}
