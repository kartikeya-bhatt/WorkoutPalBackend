package com.workoutpal.backend.controllers;
import com.workoutpal.backend.domainobjects.*;
import com.workoutpal.backend.models.User;
import com.workoutpal.backend.services.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/register", produces = "application/json")
    public ResponseEntity<String> register(@RequestBody LoginDO loginDO) {
        return userService.register(loginDO);
    }

    @PostMapping(path = "/login", produces = "application/json")
    public ResponseEntity<User> login(@RequestBody LoginDO loginDO) {
        return userService.login(loginDO);
    }

    @PostMapping(path = "/edit/workoutName", produces = "application/json")
    public ResponseEntity<String> editWorkoutName(@RequestBody EditWorkoutNameDO editWorkoutNameDODO) {
        return userService.editWorkoutName(editWorkoutNameDODO);
    }

    @PutMapping(path = "/add/exercise", produces = "application/json")
    public ResponseEntity<String> addExercise(@RequestBody AddExerciseDO addExerciseDO) {
        return userService.addExercise(addExerciseDO);
    }

    @DeleteMapping (path = "/remove/exercise", produces = "application/json")
    public ResponseEntity<String> removeExercise(@RequestBody RemoveExerciseDO removeExerciseDO) {
        return userService.removeExercise(removeExerciseDO);
    }

    @PostMapping(path = "/edit/exercise", produces = "application/json")
    public ResponseEntity<String> editExercise(@RequestBody EditExerciseDO editExerciseDO) {
        return userService.editExercise(editExerciseDO);
    }

    @PostMapping(path = "/reorder", produces = "application/json")
    public ResponseEntity<String> reorderList(@RequestBody ReorderListDO reorderListDO) {
        return userService.reorderList(reorderListDO);
    }





}