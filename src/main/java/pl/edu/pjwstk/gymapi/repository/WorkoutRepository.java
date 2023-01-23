package pl.edu.pjwstk.gymapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pjwstk.gymapi.model.Workout;
import pl.edu.pjwstk.gymapi.model.enums.ExerciseType;

import java.util.Optional;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    Optional<Workout> findWorkoutByNameAndExerciseType(String name, ExerciseType exerciseType);
    Workout findWorkoutByName(String name);
}
