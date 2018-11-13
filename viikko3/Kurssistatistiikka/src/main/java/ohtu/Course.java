package ohtu;

import java.util.Arrays;

public class Course {

    private int week;
    private int[] exercises;
    private String name;
    private String fullName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    public void setWeek(int week) {
        this.week = week;
    }

    public int getWeek() {
        return week;
    }

    public int[] getExercises() {
        return exercises;
    }

    public void setExercises(int[] exercises) {
        this.exercises = exercises;
    }

    public String getName() {
        return name;
    }

    public void setName(String course) {
        this.name = course;
    }

    @Override
    public String toString() {
        return name;
    }

}
