package pl.edu.pjwstk.gymapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjwstk.gymapi.model.Equipment;
import pl.edu.pjwstk.gymapi.model.enums.ExerciseType;
import pl.edu.pjwstk.gymapi.service.EquipmentService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/equipment/", produces = MediaType.APPLICATION_JSON_VALUE)
public class EquipmentController {
    EquipmentService equipmentService;

    @Autowired
    public EquipmentController(EquipmentService equipmentService){
        this.equipmentService = equipmentService;
    }

    @GetMapping
    public ResponseEntity<List<Equipment>> getAllEquipment(){
        return ResponseEntity.ok(equipmentService.getAllEquipments());
    }

    @PostMapping
    public ResponseEntity<Equipment> createEquipment(@RequestBody Equipment equipment){
        return ResponseEntity.ok(equipmentService.createEquipment(equipment));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipment> getEquipmentById(@PathVariable("id") Long id){
        return ResponseEntity.ok(equipmentService.getEquipmentById(id));
    }

    @GetMapping ("/get")
    public ResponseEntity<Equipment> getEquipmentRequestParam(@RequestParam(name = "id") Long id){
        return ResponseEntity.ok(equipmentService.getEquipmentById(id));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteEquipmentById(@RequestParam("id") Long id){
        equipmentService.deleteEquipmentById(id);
        return ResponseEntity.ok("ok");
    }


    @GetMapping("/{name}/{exerciseType}")
    public ResponseEntity<Equipment> findEquipmentByNameAndExerciseType(@PathVariable("name")String name, @PathVariable("exerciseType") ExerciseType exerciseType){
        return ResponseEntity.ok(equipmentService.findByNameAndExerciseType(name, exerciseType));
    }


}
