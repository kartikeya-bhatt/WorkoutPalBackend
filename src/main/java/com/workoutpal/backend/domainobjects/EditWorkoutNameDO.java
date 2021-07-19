package com.workoutpal.backend.domainobjects;
import java.math.BigInteger;

public class EditWorkoutNameDO {

    String username;
    String dayName;
    String workoutName;

    public EditWorkoutNameDO() {}

    public EditWorkoutNameDO(String username, String dayName, String workoutName) {
        this.username = username;
        this.dayName = dayName;
        this.workoutName = workoutName;
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

    public String getWorkoutName() {
        return workoutName;
    }

    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }
}
