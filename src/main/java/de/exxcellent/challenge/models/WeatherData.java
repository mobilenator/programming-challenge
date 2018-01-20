package de.exxcellent.challenge.models;

public class WeatherData implements HasSpreadedValues {
    private int day;
    private int maxTmp;
    private int minTmp;
    public static final String DAY_PROPERTY_NAME = "Day";
    public static final String MAX_TMP_PROPERTY_NAME = "MxT";
    public static final String MIN_TMP_PROPERTY_NAME = "MnT";


    public WeatherData(int day, int maxTmp, int minTmp) {
        this.day = day;
        this.maxTmp = maxTmp;
        this.minTmp = minTmp;
    }

    public int getMaxTmp() {
        return maxTmp;
    }

    public void setMaxTmp(int maxTmp) {
        this.maxTmp = maxTmp;
    }

    public int getMinTmp() {
        return minTmp;
    }

    public void setMinTmp(int minTmp) {
        this.minTmp = minTmp;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public int calculateSpread() {
        return this.maxTmp - this.minTmp;
    }
}
