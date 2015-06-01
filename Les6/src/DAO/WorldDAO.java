package DAO;

import Modal.City;
import Modal.Country;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorldDAO {
    private static final String
        DB_URL = "jdbc:mysql://localhost:3306/blogsite_db",
        DB_DRIVER = "com.mysql.jdbc.Driver",
        DB_USERNAME = "root",
        DB_PASSWORD = "root";

    public WorldDAO() throws Exception {Class.forName(DB_DRIVER).newInstance();}

    private List<City> selectCities(String query) throws Exception{
        List<City> cityList = new ArrayList<City>();

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                cityList.add(new City(
                        resultSet.getString("Name"),
                        resultSet.getString("CountryCode"),
                        resultSet.getString("District"),
                        resultSet.getInt("Population")));
            }
        }
        catch (Exception e) {e.printStackTrace();}
        return cityList;
    }

    private List<Country> selectCountries(String query) throws Exception{
        List<Country> countryList = new ArrayList<Country>();

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                countryList.add(new Country(
                        resultSet.getString("Code"),
                        resultSet.getString("Name"),
                        resultSet.getString("Continent"),
                        resultSet.getString("Region"),
                        resultSet.getDouble("SurfaceArea"),
                        resultSet.getInt("Population"),
                        resultSet.getDouble("LifeExpectancy"),
                        resultSet.getString("GovernmentForm")));
            }
        }
        catch (Exception e) {e.printStackTrace();}
        return countryList;
    }

    public List<Country> getAllCountries() {
        try {
            return selectCountries("SELECT * FROM world_db.country");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Country> getAllWestEuropeanCountries() {
        try {
            return selectCountries("SELECT * FROM world_db.country WHERE Region = 'Western Europe'");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Country> getCountryWithLargestSurface() {
        try {
            return selectCountries("SELECT * FROM world_db.country ORDER BY SurfaceArea DESC LIMIT 1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Country> gatAllRepublics() {
        try {
            return selectCountries("SELECT * FROM world_db.country WHERE GovernmentForm LIKE '%Republic%'");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Country> get10LargestPopulations() {
        try {
            return selectCountries("SELECT * FROM world_db.country ORDER BY world_db.country.Population DESC LIMIT 10");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<City> get10LargestCities() {
        try {
            return selectCities("SELECT * FROM world_db.city ORDER BY world_db.city.Population DESC LIMIT 10");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
