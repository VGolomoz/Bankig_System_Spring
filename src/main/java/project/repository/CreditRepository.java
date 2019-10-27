package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.model.Credit;

public interface CreditRepository extends JpaRepository<Credit, Long> {
}
