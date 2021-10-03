package services;

import repository.DBManager;
import models.Movie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;




public class MovieService {

//Services called from controllers that returns what the client requests


  // Search finds first movie
  public Movie findMovie(String title) {
    Movie tmp = null;
    try {
      Connection con = DBManager.getConnection();
      String SQL = "SELECT * FROM movies WHERE title like ?";
      PreparedStatement ps = con.prepareStatement(SQL);
      ps.setString(1, "%" + title + "%");
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        tmp = new Movie(rs.getInt(1),
            rs.getInt(2),
            rs.getInt(3),
            rs.getString(4),
            rs.getString(5),
            rs.getInt(6),
            rs.getString(7));
      }
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    return tmp;
  }

  // Search retrieves random movie
  public Movie findRadomMovie() {
    Movie tmp = null;
    try {
      Connection con = DBManager.getConnection();
      String SQL = "SELECT * FROM movies ORDER BY RAND() LIMIT 1";
      PreparedStatement ps = con.prepareStatement(SQL);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        tmp = new Movie(rs.getInt(1),
            rs.getInt(2),
            rs.getInt(3),
            rs.getString(4),
            rs.getString(5),
            rs.getInt(6),
            rs.getString(7));
      }
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    return tmp;
  }


  // Search retrieves all matches, including search by substring
  public ArrayList<Movie> findTop10() {
    ArrayList<Movie> movies = new ArrayList<>();
    Movie tmp = null;
    try {
      Connection con = DBManager.getConnection();
      String SQL = "SELECT * FROM movies ORDER BY RAND() LIMIT 10";
      PreparedStatement ps = con.prepareStatement(SQL);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        tmp = new Movie(rs.getInt(1),
            rs.getInt(2),
            rs.getInt(3),
            rs.getString(4),
            rs.getString(5),
            rs.getInt(6),
            rs.getString(7));

        movies.add(tmp);
      }
      Movie movie = new Movie();
      Collections.sort(movies, movie.sorterTop10Movies);
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    return movies;
  }

  /*public void printTitlePorularity10() {
    ArrayList<Movie> topTen = findTop10();
    for (int i = 0; i < topTen.size(); i++) {
      System.out.println("\nMovie title: " + topTen.get(i).getTitle() +
          "Popularity: " + topTen.get(i).getPopularity());
    }
  }*/

  // Search retrieves all matches, including search by substring
  public int findAmountWithAward() {
    int result = -1;
    try {

      Connection con = DBManager.getConnection();
      String SQL = "SELECT COUNT(awards) FROM movies WHERE awards = \"YES\"";
      /*String SQL = "SELECT * FROM movies WHERE awards = \"YES\"";*/
      PreparedStatement ps = con.prepareStatement(SQL);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = rs.getInt(1);
      }
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    return result;
  }

}
