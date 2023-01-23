package pl.edu.pjwstk.gymapi.model;

import jakarta.persistence.*;
import pl.edu.pjwstk.gymapi.model.enums.ExerciseType;

@Entity
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private ExerciseType exerciseType;

    @ManyToOne()
    @JoinColumn(name="workout_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Workout workout;

    public Equipment(){}

    public Equipment(Long id, String name, ExerciseType exerciseType, Workout workout) {
        this.id = id;
        this.name = name;
        this.exerciseType = exerciseType;
        this.workout = workout;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public ExerciseType getExerciseType() {
        return exerciseType;
    }

    public Workout getWorkout() {
        return workout;
    }

}
