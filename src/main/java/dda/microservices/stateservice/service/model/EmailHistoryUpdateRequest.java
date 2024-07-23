package dda.microservices.stateservice.service.model;

import dda.microservices.stateservice.repository.enums.EmailStatus;

public record EmailHistoryUpdateRequest(
    String recipientEmail,
    String subject,
    String message,
    EmailStatus status) {

}
