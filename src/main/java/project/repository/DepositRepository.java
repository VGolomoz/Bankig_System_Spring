package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.model.Deposit;

public interface DepositRepository extends JpaRepository<Deposit, Long> {
}
