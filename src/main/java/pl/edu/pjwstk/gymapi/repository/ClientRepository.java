package pl.edu.pjwstk.gymapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pjwstk.gymapi.model.Client;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findClientByFirstNameAndLastName(String firstName, String lastName);
    Client findClientByLastName(String lastName);
}
