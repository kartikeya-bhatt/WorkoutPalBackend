package com.workoutpal.backend.services;
import com.workoutpal.backend.domainobjects.*;
import com.workoutpal.backend.models.Day;
import com.workoutpal.backend.models.Exercise;
import com.workoutpal.backend.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserService {

    private final MongoTemplate template;
    private ArrayList<String> list = new ArrayList<String>();


    @Autowired
    public UserService(MongoTemplate template) {
        this.template = template;
        list.add("Monday");
        list.add("Tuesday");
        list.add("Wednesday");
        list.add("Thursday");
        list.add("Friday");
        list.add("Saturday");
        list.add("Sunday");
    }

    public ResponseEntity<User> login(LoginDO loginDO) {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(loginDO.getUsername()));
        User user = template.findOne(query, User.class);

        if (user == null || !user.getPassword().equals(loginDO.getPassword()))
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    public ResponseEntity<String> register(LoginDO loginDO) {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(loginDO.getUsername()));
        User user =  template.findOne(query, User.class);

        if (user != null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        user = loginDO.toUser();

        List<Day> days = new ArrayList<Day> ();
        days.add(new Day("Monday"));
        days.add(new Day("Tuesday"));
        days.add(new Day("Wednesday"));
        days.add(new Day("Thursday"));
        days.add(new Day("Friday"));
        days.add(new Day("Saturday"));
        days.add(new Day("Sunday"));

        user.setDays(days);
        template.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<String> editWorkoutName(EditWorkoutNameDO editWorkoutNameDO) {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(editWorkoutNameDO.getUsername()));

        User user = template.findOne(query, User.class);
        List<Day> days = user.getDays();

        Day day = days.get(list.indexOf(editWorkoutNameDO.getDayName()));
        day.setWorkoutName(editWorkoutNameDO.getWorkoutName());
        days.set(list.indexOf(editWorkoutNameDO.getDayName()), day);

        Update update = new Update();
        update.set("days", days);

        template.findAndModify(query, update, User.class);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    public ResponseEntity<String> addExercise(AddExerciseDO addExerciseDO) {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(addExerciseDO.getUsername()));
        User user = template.findOne(query, User.class);
        List<Day> days = user.getDays();

        Day day = days.get(list.indexOf(addExerciseDO.getDayName()));
        day.getExercises().add(new Exercise());
        days.set(list.indexOf(addExerciseDO.getDayName()), day);

        Update update = new Update();
        update.set("days", days);

        template.findAndModify(query, update, User.class);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    public ResponseEntity<String> removeExercise(RemoveExerciseDO removeExerciseDO) {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(removeExerciseDO.getUsername()));
        User user = template.findOne(query, User.class);
        List<Day> days = user.getDays();

        Day day = days.get(list.indexOf(removeExerciseDO.getDayName()));
        day.getExercises().remove(removeExerciseDO.getIndex());
        days.set(list.indexOf(removeExerciseDO.getDayName()), day);

        Update update = new Update();
        update.set("days", days);

        template.findAndModify(query, update, User.class);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    public ResponseEntity<String> editExercise(EditExerciseDO exerciseDO) {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(exerciseDO.getUsername()));
        User user = template.findOne(query, User.class);
        List<Day> days = user.getDays();

        Day day = days.get(list.indexOf(exerciseDO.getDayName()));
        Exercise exercise = new Exercise(
                exerciseDO.getExerciseName(),
                exerciseDO.getReps(),
                exerciseDO.getSets(),
                exerciseDO.getWeight()
        );

        day.getExercises().set(exerciseDO.getIndex(), exercise);
        days.set(list.indexOf(exerciseDO.getDayName()), day);

        Update update = new Update();
        update.set("days", days);

        template.findAndModify(query, update, User.class);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    public ResponseEntity<String> reorderList(ReorderListDO reorderListDO) {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(reorderListDO.getUsername()));
        User user = template.findOne(query, User.class);
        List<Day> days = user.getDays();

        Day day = days.get(list.indexOf(reorderListDO.getDayName()));
        day.setExercises(reorderListDO.getExerciseList());
        days.set(list.indexOf(reorderListDO.getDayName()), day);

        Update update = new Update();
        update.set("days", days);

        template.findAndModify(query, update, User.class);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}
