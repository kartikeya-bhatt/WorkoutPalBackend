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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Document(collection = "users")
public class User {

    @Id
    BigInteger id;

    @Field("username")
    String username;

    @Field("password")
    String password;

    @Field("days")
    List<Day> days;

    public User () {}

    public User (String username, String password, List<Day> days) {
        this.username = username;
        this.password = password;
        this.days = days;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public BigInteger getId() { return id; }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }
}



