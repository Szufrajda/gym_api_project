package pl.edu.pjwstk.gymapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pjwstk.gymapi.model.Instructor;

import java.util.Optional;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    Optional<Instructor> findInstructorByFirstNameAndLastName(String firstName, String lastName);
    Instructor findInstructorByLastName(String lastName);
}
