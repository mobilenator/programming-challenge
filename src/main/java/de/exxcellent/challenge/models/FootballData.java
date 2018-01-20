package de.exxcellent.challenge.models;

public class FootballData implements HasSpreadedValues {

    private String teamName;
    private int goals;
    private int goalsAllowed;

    public static final String TEAM_PROPERTY_NAME = "Team";
    public static final String GOALS_PROPERTY_NAME = "Goals";
    public static final String GOALS_ALLOWED_PROPERTY_NAME = "Goals Allowed";

    public FootballData(String teamName,int goals, int goalsAllowed){
        this.teamName = teamName;
        this.goals = goals;
        this.goalsAllowed = goalsAllowed;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getGoalsAllowed() {
        return goalsAllowed;
    }

    public void setGoalsAllowed(int goalsAllowed) {
        this.goalsAllowed = goalsAllowed;
    }

    @Override
    public int calculateSpread() {
        return Math.abs(this.goals-this.goalsAllowed);
    }
}
