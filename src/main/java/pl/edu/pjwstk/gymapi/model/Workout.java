package pl.edu.pjwstk.gymapi.model;

import jakarta.persistence.*;
import pl.edu.pjwstk.gymapi.model.enums.ExerciseType;

@Entity
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private ExerciseType exerciseType;


    public Workout(){}

    public Workout(Long id, String name, ExerciseType exerciseType) {
        this.id = id;
        this.name = name;
        this.exerciseType = exerciseType;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ExerciseType getExerciseType() {
        return exerciseType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExerciseType(ExerciseType exerciseType) {
        this.exerciseType = exerciseType;
    }
}
