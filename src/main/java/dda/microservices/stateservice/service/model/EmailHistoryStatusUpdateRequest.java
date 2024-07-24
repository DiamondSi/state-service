package dda.microservices.stateservice.service.model;

import dda.microservices.stateservice.repository.enums.EmailStatus;

public record EmailHistoryStatusUpdateRequest(EmailStatus status) {

}
