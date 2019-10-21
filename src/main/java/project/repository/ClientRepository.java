package project.repository;

import org.jboss.logging.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByEmail (String clientEmail);

//    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false " +
//            "END FROM Client c WHERE c.email = :email")

    boolean existsByEmail(String email);

}