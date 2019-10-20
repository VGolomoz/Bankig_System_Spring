package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByEmail (String clientEmail);

}