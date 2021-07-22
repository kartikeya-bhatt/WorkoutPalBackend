package com.workoutpal.backend.domainobjects;


public class EditExerciseDO {
    String username;
    String dayName;
    int index;
    String exerciseName;
    int reps;
    int sets;
    int weight;

    public EditExerciseDO () {}

    public EditExerciseDO(String username, String dayName, int index, String exerciseName, int reps, int sets, int weight) {
        this.username = username;
        this.dayName = dayName;
        this.index = index;
        this.exerciseName = exerciseName;
        this.reps = reps;
        this.sets = sets;
        this.weight = weight;
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

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}
