package de.exxcellent.challenge;


import de.exxcellent.challenge.models.HasSpreadedValues;
import de.exxcellent.challenge.models.WeatherData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class AnalyzerTest {


    private WeatherData smallesSpreadWeatherData;
    private ArrayList<HasSpreadedValues> weatherRecords;
    String smallestSpreadDay;
    String smallestSpreadTeam;

    @Before
    public void setUp() throws Exception {
        Analyzer analyzer = new Analyzer();

        WeatherData day1 = new WeatherData(1, 1, 1);
        WeatherData day2 = new WeatherData(2, 20, 10);
        WeatherData day3 = new WeatherData(3, 30, 10);
        weatherRecords = new ArrayList<>(Arrays.asList(day1, day2, day3));
        smallesSpreadWeatherData = (WeatherData) analyzer.findSmallestSpreadRecord(weatherRecords);

        smallestSpreadDay = analyzer.findSmallestSpreadedDay("weather.csv");
        smallestSpreadTeam = analyzer.findSmallestSpreadTeam("football.csv");

    }

    @Test
    public void findSmallestSpreadRecord() {
        Assert.assertEquals("SmallesSpreadRecord", 1, smallesSpreadWeatherData.getDay());
        Assert.assertEquals("SmallesSpreadRecord", 1, smallesSpreadWeatherData.getMaxTmp());
        Assert.assertEquals("SmallesSpreadRecord", 1, smallesSpreadWeatherData.getMinTmp());

        Assert.assertEquals("Day with smallest temp spread", "14", smallestSpreadDay);
        Assert.assertEquals("Day with smallest temp spread", "Aston_Villa", smallestSpreadTeam);
    }

}


