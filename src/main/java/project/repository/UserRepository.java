package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.model.Client;

public interface UserRepository extends JpaRepository<Client, Long> {

}