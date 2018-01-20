package de.exxcellent.challenge;

import de.exxcellent.challenge.models.WeatherData;
import org.apache.commons.csv.CSVRecord;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CSVImporterTest {


    private ArrayList<CSVRecord> records;

    @Before
    public void setUp() throws Exception {
        CSVImporter csvImporter = new CSVImporter();
        records = csvImporter.importCSV("weather.csv");
    }

    @Test
    public void importCSVTest() {
        Assert.assertEquals("CSVImporter Day", "2", records.get(1).get(WeatherData.DAY_PROPERTY_NAME));
        Assert.assertEquals("CSVImporter MaxTmp", "61", records.get(13).get(WeatherData.MAX_TMP_PROPERTY_NAME));
        Assert.assertEquals("CSVImporter MinTmp", "45", records.get(29).get(WeatherData.MIN_TMP_PROPERTY_NAME));
    }

}

