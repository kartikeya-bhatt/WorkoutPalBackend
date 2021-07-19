package com.workoutpal.backend.domainobjects;

public class AddExerciseDO {
    String username;
    String dayName;

    public AddExerciseDO () {}

    public AddExerciseDO(String username, String dayName) {
        this.username = username;
        this.dayName = dayName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }
}
