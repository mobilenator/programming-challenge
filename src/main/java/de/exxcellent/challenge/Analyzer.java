package de.exxcellent.challenge;

import de.exxcellent.challenge.models.HasSpreadedValues;

import java.util.ArrayList;

public class Analyzer {
    public Analyzer() {
    }

    //Only finds returns the first Entry with the highest Spread. A later record with the same Spread is ignored.
    //Errors with empty Lists yet.
    public HasSpreadedValues findSmallestSpreadRecord(ArrayList<HasSpreadedValues> records) {
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


