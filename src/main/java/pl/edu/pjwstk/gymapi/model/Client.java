package pl.edu.pjwstk.gymapi.model;

import jakarta.persistence.*;
import pl.edu.pjwstk.gymapi.model.enums.Gender;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column
    private int age;


    @OneToOne(fetch = FetchType.EAGER)
    private Workout workout;

    public Client(){}

    public Client(Long id, String firstName, String lastName, Gender gender, int age, Workout workout) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.workout = workout;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public Workout getWorkout() {
        return workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

}
