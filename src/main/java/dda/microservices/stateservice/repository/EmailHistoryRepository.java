package dda.microservices.stateservice.repository;

import dda.microservices.stateservice.repository.entity.EmailHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailHistoryRepository extends JpaRepository<EmailHistory, Long> {

}
