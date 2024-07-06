package dda.microservices.stateservice.service.mapper.impl;

import dda.microservices.stateservice.repository.entity.EmailHistory;
import dda.microservices.stateservice.service.mapper.EmailHistoryMapper;
import dda.microservices.stateservice.service.model.EmailHistoryDto;
import org.springframework.stereotype.Component;

@Component
public class EmailHistoryMapperImpl implements EmailHistoryMapper {

  @Override
  public EmailHistoryDto toDto(EmailHistory emailHistory) {
    if (emailHistory == null) {
      return null;
    }
    return new EmailHistoryDto(emailHistory.getId(), emailHistory.getRecipientEmail(),
        emailHistory.getSubject(), emailHistory.getMessage(), emailHistory.getCreatedAt(),
        emailHistory.getStatus());
  }
}
