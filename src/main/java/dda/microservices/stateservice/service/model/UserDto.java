package dda.microservices.stateservice.service.model;

import java.util.List;

public record UserDto(
    Long id,
    String email,
    String username,
    List<EmailHistoryDto> emailHistories) {

}
