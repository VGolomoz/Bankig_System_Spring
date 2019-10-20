package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.model.ClientAccount;

public interface UserAccountRepository extends JpaRepository<ClientAccount, Long> {
}
