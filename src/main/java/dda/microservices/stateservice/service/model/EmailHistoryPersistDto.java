package dda.microservices.stateservice.service.model;

import dda.microservices.stateservice.repository.enums.EmailStatus;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmailHistoryPersistDto {

  private String recipientEmail;
  private String subject;
  private String message;
  private LocalDateTime createdAt;
  private EmailStatus status;
  private Long userId;
}
