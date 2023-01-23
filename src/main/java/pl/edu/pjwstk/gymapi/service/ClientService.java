package pl.edu.pjwstk.gymapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pjwstk.gymapi.model.Client;
import pl.edu.pjwstk.gymapi.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client createClient(Client client){
        return clientRepository.save(client);
    }

    public Client findByNameAndLastName(String firstName, String lastName){
        Optional<Client> client = clientRepository.findClientByFirstNameAndLastName(firstName, lastName);
        if (client.isPresent()){
            return client.get();
        }
        throw new IllegalArgumentException();
    }

    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    public Client getClientById(Long id){
        return clientRepository.getReferenceById(id);
    }

    public void deleteClientById(Long id){
        clientRepository.deleteById(id);
    }
}
