package dda.microservices.stateservice.service.mapper;

import dda.microservices.stateservice.repository.entity.EmailHistory;
import dda.microservices.stateservice.service.model.EmailHistoryDto;
import dda.microservices.stateservice.service.model.EmailHistoryPersistDto;
import dda.microservices.stateservice.service.model.EmailHistoryResponse;

public interface EmailHistoryMapper {

  EmailHistoryDto toDto(EmailHistory emailHistory);

  EmailHistory toEntity(EmailHistoryPersistDto emailHistoryPersistDto);
  EmailHistoryResponse toResponseDto(EmailHistory emailHistory);
}
