package pl.edu.pjwstk.gymapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pjwstk.gymapi.model.Instructor;
import pl.edu.pjwstk.gymapi.repository.InstructorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

    InstructorRepository instructorRepository;

    @Autowired
    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    public Instructor createInstructor(Instructor instructor){
        return instructorRepository.save(instructor);
    }

    public Instructor findByNameAndLastName(String firstName, String lastName){
        Optional<Instructor> instructor = instructorRepository.findInstructorByFirstNameAndLastName(firstName, lastName);
        if (instructor.isPresent()){
            return instructor.get();
        }
        throw new IllegalArgumentException();
    }

    public List<Instructor> getAllInstructors(){
        return instructorRepository.findAll();
    }

    public Instructor getInstructorById(Long id){
        return instructorRepository.getReferenceById(id);
    }

    public void deleteInstructorById(Long id){
        instructorRepository.deleteById(id);
    }
}
