package ohtu;

import java.util.Arrays;

public class Submission {

    private int week;
    private int hours;
    private int[] exercises;
    private String course;

    public void setWeek(int week) {
        this.week = week;
    }

    public int getWeek() {
        return week;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int[] getExercises() {
        return exercises;
    }

    public void setExercises(int[] exercises) {
        this.exercises = exercises;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "viikko " + week + ":\n"
                + " tehtyjä tehtäviä " + exercises.length + 
                " aikaa kului " + hours + " tehdyt tehtävät: " +
                Arrays.toString(exercises);
    }

}
