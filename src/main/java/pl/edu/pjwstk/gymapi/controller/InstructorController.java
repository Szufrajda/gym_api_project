package pl.edu.pjwstk.gymapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjwstk.gymapi.model.Client;
import pl.edu.pjwstk.gymapi.model.Instructor;
import pl.edu.pjwstk.gymapi.service.InstructorService;

import java.util.List;

@RestController
@RequestMapping("/api/instructor/")
public class InstructorController {

    InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    public ResponseEntity<List<Instructor>> getAllInstructors(){
        return ResponseEntity.ok(instructorService.getAllInstructors());
    }

    @PostMapping
    public ResponseEntity<Instructor> createInstructor(@RequestBody Instructor instructor){
        return ResponseEntity.ok(instructorService.createInstructor(instructor));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instructor> getInstructorById(@PathVariable("id") Long id){
        return ResponseEntity.ok(instructorService.getInstructorById(id));
    }

    @GetMapping("/get")
    public ResponseEntity<Instructor> getInstructorByIdRequestParam(@RequestParam(name = "id") Long id){
        return ResponseEntity.ok(instructorService.getInstructorById(id));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteInstructorById(@PathVariable("id") Long id){
        instructorService.deleteInstructorById(id);
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/{name}/{lastName}")
    public ResponseEntity<Instructor> findClientByNameAndLastName(@PathVariable("name")String firstName, @PathVariable("lastName") String lastName) {
        return ResponseEntity.ok(instructorService.findByNameAndLastName(firstName, lastName));
    }
}
