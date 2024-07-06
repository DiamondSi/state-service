package dda.microservices.stateservice.repository;

import dda.microservices.stateservice.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
