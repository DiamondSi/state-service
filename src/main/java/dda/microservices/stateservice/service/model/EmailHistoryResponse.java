package dda.microservices.stateservice.service.model;

import dda.microservices.stateservice.repository.enums.EmailStatus;
import java.time.LocalDateTime;

public record EmailHistoryResponse(
    Long id,
    LocalDateTime createdAt,
    EmailStatus status) {
}
