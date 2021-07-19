package com.workoutpal.backend.models;

import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.Nullable;
import io.github.kaiso.relmongo.annotation.CascadeType;
import io.github.kaiso.relmongo.annotation.FetchType;
import io.github.kaiso.relmongo.annotation.JoinProperty;
import io.github.kaiso.relmongo.annotation.OneToMany;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "exercises")
public class Exercise {

    @Field("name")
    private String name;

    @Field("reps")
    private int reps;

    @Field("sets")
    private int sets;

    @Field("weight")
    private int weight;

    public Exercise (String name, int reps, int sets, int weight) {
        this.name = name;
        this.reps = reps;
        this.sets = sets;
        this.weight = weight;
    }

    public Exercise () {
        this.name = "Enter workout name";
        this.reps = 0;
        this.sets = 0;
        this.weight = 0;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "name='" + name + '\'' +
                ", reps=" + reps +
                ", sets=" + sets +
                ", weight=" + weight +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
