package com.workoutpal.backend.domainobjects;

import com.workoutpal.backend.models.Exercise;

import java.util.List;

public class ReorderListDO {
    String username;
    String dayName;
    List<Exercise> exerciseList;

    public ReorderListDO () {}

    public ReorderListDO(String username, String dayName, List<Exercise> exerciseList) {
        this.username = username;
        this.dayName = dayName;
        this.exerciseList = exerciseList;
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

    public List<Exercise> getExerciseList() {
        return exerciseList;
    }

    public void setExerciseList(List<Exercise> exerciseList) {
        this.exerciseList = exerciseList;
    }
}
