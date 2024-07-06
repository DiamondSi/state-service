package dda.microservices.stateservice.service.model;

import dda.microservices.stateservice.repository.enums.EmailStatus;
import java.time.LocalDateTime;

public record EmailHistoryDto(
    Long id,
    String recipientEmail,
    String subject,
    String message,
    LocalDateTime createdAt,
    EmailStatus status) {

}
