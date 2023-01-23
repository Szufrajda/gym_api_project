package pl.edu.pjwstk.gymapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pjwstk.gymapi.model.Workout;
import pl.edu.pjwstk.gymapi.model.enums.ExerciseType;
import pl.edu.pjwstk.gymapi.repository.WorkoutRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutService {

    private WorkoutRepository workoutRepository;

    @Autowired

    public WorkoutService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    public Workout createWorkout(Workout workout){
        return workoutRepository.save(workout);
    }

    public Workout findByNameAndExerciseType(String name, ExerciseType exerciseType){
        Optional<Workout> workout = workoutRepository.findWorkoutByNameAndExerciseType(name, exerciseType);
        if(workout.isPresent()){
            return workout.get();
        }
        throw new IllegalArgumentException();
    }

    public List<Workout> getAllWorkouts(){
        return workoutRepository.findAll();
    }

    public Workout getWorkoutById(Long id){
        return workoutRepository.getReferenceById(id);
    }

    public void deleteWorkoutById(Long id){
        workoutRepository.deleteById(id);
    }
}
