package dda.microservices.stateservice.service.mapper.impl;

import dda.microservices.stateservice.repository.entity.EmailHistory;
import dda.microservices.stateservice.service.mapper.EmailHistoryMapper;
import dda.microservices.stateservice.service.model.EmailHistoryDto;
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
  public EmailHistory toEntity(EmailHistoryDto dto) {
    if (dto == null) {
      return null;
    }
    EmailHistory entity = new EmailHistory();
    entity.setId(dto.id());
    entity.setRecipientEmail(dto.recipientEmail());
    entity.setSubject(dto.subject());
    entity.setMessage(dto.message());
    entity.setCreatedAt(dto.createdAt());
    entity.setStatus(dto.status());

    return entity;
  }
}
