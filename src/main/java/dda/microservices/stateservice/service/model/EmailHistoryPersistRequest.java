package dda.microservices.stateservice.service.model;

public record EmailHistoryPersistRequest(
    String recipientEmail,
    String subject,
    String message) {

}
