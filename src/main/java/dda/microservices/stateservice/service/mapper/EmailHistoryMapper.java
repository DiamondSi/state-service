package dda.microservices.stateservice.service.mapper;

import dda.microservices.stateservice.repository.entity.EmailHistory;
import dda.microservices.stateservice.service.model.EmailHistoryDto;

public interface EmailHistoryMapper {

  EmailHistoryDto toDto(EmailHistory emailHistory);
}
