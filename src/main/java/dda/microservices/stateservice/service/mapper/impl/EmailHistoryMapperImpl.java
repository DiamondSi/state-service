package dda.microservices.stateservice.service.mapper.impl;

import dda.microservices.stateservice.repository.entity.EmailHistory;
import dda.microservices.stateservice.repository.entity.User;
import dda.microservices.stateservice.service.mapper.EmailHistoryMapper;
import dda.microservices.stateservice.service.model.EmailHistoryDto;
import dda.microservices.stateservice.service.model.EmailHistoryPersistDto;
import dda.microservices.stateservice.service.model.EmailHistoryResponse;
import org.springframework.stereotype.Component;

@Component
public class EmailHistoryMapperImpl implements EmailHistoryMapper {

  @Override
  public EmailHistoryDto toDto(EmailHistory entity) {
    if (entity == null) {
      return null;
    }
    return new EmailHistoryDto(entity.getId(), entity.getRecipientEmail(),
        entity.getSubject(), entity.getMessage(), entity.getCreatedAt(),
        entity.getStatus());
  }

  @Override
  public EmailHistory toEntity(EmailHistoryPersistDto dto) {
    if (dto == null) {
      return null;
    }

    final var user = new User();
    user.setId(dto.getUserId());

    final var entity = new EmailHistory();
    entity.setRecipientEmail(dto.getRecipientEmail());
    entity.setSubject(dto.getSubject());
    entity.setMessage(dto.getMessage());
    entity.setCreatedAt(dto.getCreatedAt());
    entity.setStatus(dto.getStatus());
    entity.setUser(user);

    return entity;
  }

  @Override
  public EmailHistoryResponse toResponseDto(EmailHistory emailHistory) {
    if (emailHistory == null) {
      return null;
    }
    return new EmailHistoryResponse(emailHistory.getId(), emailHistory.getCreatedAt(),
        emailHistory.getStatus());

  }
}
