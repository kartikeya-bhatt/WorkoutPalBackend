package com.workoutpal.backend.domainobjects;

public class RemoveExerciseDO {
    String username;
    String dayName;
    int index;

    public RemoveExerciseDO () {}

    public RemoveExerciseDO (String username, String dayName, int index) {
        this.username = username;
        this.dayName = dayName;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
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
