package pl.edu.pjwstk.gymapi.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjwstk.gymapi.model.Workout;
import pl.edu.pjwstk.gymapi.model.enums.ExerciseType;
import pl.edu.pjwstk.gymapi.service.WorkoutService;

import java.util.List;

@RestController
@RequestMapping("/api/workout")
public class WorkoutController {
    WorkoutService workoutService;

    @Autowired
    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @GetMapping
    public ResponseEntity<List<Workout>> getAllWorkouts(){
        return ResponseEntity.ok(workoutService.getAllWorkouts());
    }

    @PostMapping
    public ResponseEntity<Workout> createWorkout(@RequestBody Workout workout){
        return ResponseEntity.ok(workoutService.createWorkout(workout));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Workout> getWorkoutById(@PathVariable("id") Long id){
        return ResponseEntity.ok(workoutService.getWorkoutById(id));
    }

    @GetMapping("/get")
    public ResponseEntity<Workout> getWorkoutByIdRequestParam(@RequestParam(name = "id") Long id){
        return ResponseEntity.ok(workoutService.getWorkoutById(id));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteWorkoutById(@RequestParam("id") Long id){
        workoutService.deleteWorkoutById(id);
        return ResponseEntity.ok("ok");
    }


    @GetMapping("/{name}/{exerciseType}")
    public ResponseEntity<Workout> findWorkoutesByNameAndExerciseType(@PathVariable("name")String name, @PathVariable("exerciseType") ExerciseType exerciseType){
        return ResponseEntity.ok(workoutService.findByNameAndExerciseType(name, exerciseType));
    }

}
