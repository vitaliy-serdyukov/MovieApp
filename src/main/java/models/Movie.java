package models;

import java.util.Comparator;

public class Movie {

 /* Subject{
    ACTION, COMEDY, DRAMA, HORROR, MUSIC, MYSTERY, SCIENCE_FICTION,SHORT, WAR, WESTERN*/

  private int movieID;
  private  int year;
  private int length;
  private String title;
  private String subject;
  private int popularity;
  private String awards;

  public Movie(int movieID, int year, int length, String title, String subject, int popularity, String awards) {
    this.movieID = movieID;
    this.year = year;
    this.length = length;
    this.title = title;
    this.subject = subject;
    this.popularity = popularity;
    this.awards = awards;
  }

  public Movie (){};

  public int getMovieID() {
    return movieID;
  }

  public void setMovieID(int movieID) {
    this.movieID = movieID;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public int getPopularity() {
    return popularity;
  }

  public void setPopularity(int popularity) {
    this.popularity = popularity;
  }

  public String getAwards() {
    return awards;
  }

  public void setAwards(String awards) {
    this.awards = awards;
  }


  public Comparator<Movie> sorterTop10Movies = new Comparator<Movie>() {
    @Override
    public int compare(Movie m1, Movie m2) {
      return Double.compare(m1.getPopularity(), m2.getPopularity());
    }
  };


 /* @Override
  public String toString() {
    return
        "\nID number " + movieID +
        " year: " + year +
        " length: " + length +
        " title: " + title +
        " subject: " + subject +
        " popularity: " + popularity +
        " awards: " + awards;
  }*/

  @Override
  public String toString() {
    return
        "\n title: " + title +
        " popularity: " + popularity;
  }
}
