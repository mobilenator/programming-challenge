package de.exxcellent.challenge;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    public static void main(String... args) {


        String fileNameWeather = "weather.csv";
        String fileNameFootball = "football.csv";
        Analyzer analyzer = new Analyzer();
        String dayWithSmallestTempSpread = analyzer.findSmallestSpreadedDay(fileNameWeather);
        String teamWithSmallesGoalSpread = analyzer.findSmallestSpreadTeam(fileNameFootball);


        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallesGoalSpread);
    }
}
