package de.exxcellent.challenge;

import de.exxcellent.challenge.models.FootballData;
import de.exxcellent.challenge.models.HasSpreadedValues;
import de.exxcellent.challenge.models.WeatherData;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.util.ArrayList;

public class Analyzer {
    public Analyzer() {
    }

    public String findSmallestSpreadedDay(String fileName) {

        CSVImporter csvImporter = new CSVImporter();
        try {
            ArrayList<CSVRecord> weatherRecords = csvImporter.importCSV(fileName);

            ArrayList<HasSpreadedValues> weatherData = new ArrayList<HasSpreadedValues>();
            for (CSVRecord record : weatherRecords) {
                int day = Integer.parseInt(record.get(WeatherData.DAY_PROPERTY_NAME));
                int maxTmp = Integer.parseInt(record.get(WeatherData.MAX_TMP_PROPERTY_NAME));
                int minTmp = Integer.parseInt(record.get(WeatherData.MIN_TMP_PROPERTY_NAME));
                WeatherData newWeatherData = new WeatherData(day, maxTmp, minTmp);
                weatherData.add(newWeatherData);
            }
            WeatherData smallestSpreadWeatherRecord = (WeatherData) findSmallestSpreadRecord(weatherData);
            return Integer.toString(smallestSpreadWeatherRecord.getDay());
        } catch (IOException ioe) {
            return "Someday";
        }
    }

    public String findSmallestSpreadTeam(String fileName) {

        CSVImporter csvImporter = new CSVImporter();
        try {
            ArrayList<CSVRecord> footballRecords = csvImporter.importCSV(fileName);
            ArrayList<HasSpreadedValues> footballData = new ArrayList<HasSpreadedValues>();
            for (CSVRecord record : footballRecords) {
                String teamName = record.get(FootballData.TEAM_PROPERTY_NAME);
                int goals = Integer.parseInt(record.get(FootballData.GOALS_PROPERTY_NAME));
                int goalsAllowed = Integer.parseInt(record.get(FootballData.GOALS_ALLOWED_PROPERTY_NAME));
                FootballData newFootballData = new FootballData(teamName, goals, goalsAllowed);
                footballData.add(newFootballData);
            }
            FootballData smallestSpreadFootballRecord = (FootballData) findSmallestSpreadRecord(footballData);
            return smallestSpreadFootballRecord.getTeamName();


        } catch (IOException ioe) {
            return "Some Balanced Team";
        }
    }

    //Only finds returns the first Entry with the highest Spread. A later record with the same Spread is ignored.
    //Errors with empty Lists yet.
    private HasSpreadedValues findSmallestSpreadRecord(ArrayList<HasSpreadedValues> records) {
        HasSpreadedValues recordWithSmallestSpread = records.stream().findFirst().get();
        int lowestSpread = recordWithSmallestSpread.calculateSpread();
        for (HasSpreadedValues record : records) {
            int currentRecordSpread = record.calculateSpread();
            if (currentRecordSpread < lowestSpread) {
                recordWithSmallestSpread = record;
                lowestSpread = currentRecordSpread;
            }
        }
        return recordWithSmallestSpread;
    }
}


