package de.exxcellent.challenge;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;

public class CSVImporter {
    //TODO Catch IO Excpetion instead?!
    public String importCSV(String fileName)throws IOException{
        Reader in = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/de.exxcelent.challenge/"+fileName)));
        for (CSVRecord record : CSVFormat.DEFAULT.parse(in)) {
            for (String field : record) {
                System.out.print("\"" + field + "\", ");
            }
            System.out.println();
        }
        return fileName;
    }
}
