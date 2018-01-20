package de.exxcellent.challenge;


import de.exxcellent.challenge.models.FootballData;
import de.exxcellent.challenge.models.HasSpreadedValues;
import de.exxcellent.challenge.models.WeatherData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class HasSpreadValuesTest {


    private WeatherData smallesSpreadWeatherData;
    private ArrayList<HasSpreadedValues> weatherRecords;
    HasSpreadedValues day;
    HasSpreadedValues team1;
    HasSpreadedValues team2;


    @Before
    public void setUp() throws Exception {
        Analyzer analyzer = new Analyzer();

        day = new WeatherData(1, 10, -5);
        team1 = new FootballData("team1", 10, 5);
        team2 = new FootballData("team2", 5, 10);
    }

    @Test
    public void calculateSmallestSpreads() {
        Assert.assertEquals("CalculateWeatherSpread", 15, day.calculateSpread());
        Assert.assertEquals("CalculateSpreadTeam1", 5, team1.calculateSpread());
        Assert.assertEquals("CalculateSpreadTeam2", 5, team2.calculateSpread());
    }

}


