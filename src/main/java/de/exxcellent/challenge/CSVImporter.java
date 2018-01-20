package de.exxcellent.challenge;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.ArrayList;

public class CSVImporter {
    //TODO Catch IO Excpetion instead?!
    public ArrayList<CSVRecord> importCSV(String fileName)throws IOException{

        String filePath = "/de/exxcellent/challenge/"+fileName;
        InputStreamReader inputStreamReader = new InputStreamReader(getClass().getResourceAsStream(filePath));
        Reader in = new BufferedReader(inputStreamReader);

        ArrayList<CSVRecord> records = new ArrayList<CSVRecord>();

        for (CSVRecord record : CSVFormat.DEFAULT.withHeader().parse(in)) {
            records.add(record);
        }
        return records;
    }
}
