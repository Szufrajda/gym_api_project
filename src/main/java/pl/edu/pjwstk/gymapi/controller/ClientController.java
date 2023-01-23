package pl.edu.pjwstk.gymapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjwstk.gymapi.model.Client;
import pl.edu.pjwstk.gymapi.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/api/client/")
public class ClientController {

    ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients(){
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client){
        return ResponseEntity.ok(clientService.createClient(client));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id") Long id){
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @GetMapping("/get")
    public ResponseEntity<Client> getClientByIdRequestParam(@RequestParam(name = "id") Long id){
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteClientById(@PathVariable("id") Long id){
        clientService.deleteClientById(id);
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/{name}/{lastName}")
    public ResponseEntity<Client> findClientByNameAndLastName(@PathVariable("name")String firstName, @PathVariable("lastName") String lastName) {
        return ResponseEntity.ok(clientService.findByNameAndLastName(firstName, lastName));
    }
}
