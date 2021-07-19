package com.workoutpal.backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.Nullable;
import io.github.kaiso.relmongo.annotation.CascadeType;
import io.github.kaiso.relmongo.annotation.FetchType;
import io.github.kaiso.relmongo.annotation.JoinProperty;
import io.github.kaiso.relmongo.annotation.OneToMany;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "days")
public class Day {

    @Field("day_name")
    String dayName;

    @Field("workout_name")
    String workoutName;

    @Field("exercises")
    List<Exercise> exercises;

    public Day () {}

    public Day (String dayName, List<Exercise> exercises) {
        this.dayName = dayName;
        this.exercises = exercises;
        workoutName = "Enter Workout Name";
    }

    public Day (String dayName) {
        this.dayName = dayName;
        this.exercises = new ArrayList<Exercise>();
        workoutName = "Enter Workout Name";
    }

    @Override
    public String toString() {
        return "Day{" +
                ", dayName='" + dayName + '\'' +
                ", workoutName='" + workoutName + '\'' +
                ", exercises=" + exercises +
                '}';
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

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }
}