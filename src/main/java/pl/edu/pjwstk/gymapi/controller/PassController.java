package pl.edu.pjwstk.gymapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjwstk.gymapi.model.Pass;
import pl.edu.pjwstk.gymapi.model.enums.PassType;
import pl.edu.pjwstk.gymapi.service.PassService;

import java.util.List;

@RestController
@RequestMapping("/api/pass/")
public class PassController {
    PassService passService;

    @Autowired
    public PassController(PassService passService) {
        this.passService = passService;
    }

    @GetMapping
    public ResponseEntity<List<Pass>> getAllPasses(){
        return ResponseEntity.ok(passService.getPasses());
    }
    @PostMapping
    public ResponseEntity<Pass> createPass(@RequestBody Pass pass){
        return ResponseEntity.ok(passService.createPass(pass));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pass> getPassById(@PathVariable("id") Long id){
        return ResponseEntity.ok(passService.getPassById(id));
    }

    @GetMapping("/get")
    public ResponseEntity<Pass> getPassesByIdRequestParam(@RequestParam(name = "id") Long id){
        return ResponseEntity.ok(passService.getPassById(id));
    }

    @DeleteMapping
    public ResponseEntity<String> deletePassById(@RequestParam("id") Long id){
        passService.deletePassById(id);
        return ResponseEntity.ok("ok");
    }

    @PutMapping("{id}")
    public ResponseEntity<Pass> updatePass(@RequestBody Pass pass, @PathVariable("id") Long id){
        return ResponseEntity.ok(passService.updatePass(id, pass));
    }

    @GetMapping("/type")
    public ResponseEntity<List<Pass>> findPassesByPassType(@RequestParam(name = "type")PassType passType){
        return ResponseEntity.ok(passService.findPassesByPassType(passType));
    }
}
