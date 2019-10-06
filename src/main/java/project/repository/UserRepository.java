package project.repository;

import org.springframework.data.repository.CrudRepository;
import project.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}