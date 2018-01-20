package de.exxcellent.challenge;

import de.exxcellent.challenge.models.FootballData;
import de.exxcellent.challenge.models.HasSpreadedValues;
import de.exxcellent.challenge.models.WeatherData;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.util.ArrayList;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    public static void main(String... args) {


        String dayWithSmallestTempSpread = "Someday";     // Your day analysis function call …
        String teamWithSmallesGoalSpread = "A good team"; // Your goal analysis function call …

        CSVImporter csvImporter = new CSVImporter();
        String fileNameWeather = "weather.csv";
        String fileNameFootball = "football.csv";
        try {
            ArrayList<CSVRecord> weatherRecords = csvImporter.importCSV(fileNameWeather);
            ArrayList<HasSpreadedValues> weatherData = new ArrayList<HasSpreadedValues>();
            for (CSVRecord record : weatherRecords) {
                int day = Integer.parseInt(record.get(WeatherData.DAY_PROPERTY_NAME));
                int maxTmp = Integer.parseInt(record.get(WeatherData.MAX_TMP_PROPERTY_NAME));
                int minTmp = Integer.parseInt(record.get(WeatherData.MIN_TMP_PROPERTY_NAME));
                WeatherData newWeatherData = new WeatherData(day, maxTmp, minTmp);
                weatherData.add(newWeatherData);
            }
            Analyzer analyzer = new Analyzer();
            WeatherData smallestSpreadWeatherRecord = (WeatherData) analyzer.findSmallestSpreadRecord(weatherData);
            dayWithSmallestTempSpread = Integer.toString(smallestSpreadWeatherRecord.getDay());


            ArrayList<CSVRecord> footballRecords = csvImporter.importCSV(fileNameFootball);
            ArrayList<HasSpreadedValues> footballData = new ArrayList<HasSpreadedValues>();
            for (CSVRecord record : footballRecords) {
                String teamName = record.get(FootballData.TEAM_PROPERTY_NAME);
                int goals = Integer.parseInt(record.get(FootballData.GOALS_PROPERTY_NAME));
                int goalsAllowed = Integer.parseInt(record.get(FootballData.GOALS_ALLOWED_PROPERTY_NAME));
                FootballData newFootballData = new FootballData(teamName, goals, goalsAllowed);
                footballData.add(newFootballData);
            }
            FootballData smallestSpreadFootballRecord = (FootballData) analyzer.findSmallestSpreadRecord(footballData);
            teamWithSmallesGoalSpread = smallestSpreadFootballRecord.getTeamName();


        } catch (IOException ioe) {
            System.out.printf("Can not find %s%n", fileNameWeather);
        }

        // Your preparation code …


        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallesGoalSpread);
    }
}
