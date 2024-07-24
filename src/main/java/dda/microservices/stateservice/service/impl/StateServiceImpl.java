package dda.microservices.stateservice.service.impl;

import dda.microservices.stateservice.repository.enums.EmailStatus;
import dda.microservices.stateservice.service.EmailHistoryService;
import dda.microservices.stateservice.service.StateService;
import dda.microservices.stateservice.service.UserService;
import dda.microservices.stateservice.service.model.EmailHistoryPersistDto;
import dda.microservices.stateservice.service.model.EmailHistoryPersistRequest;
import dda.microservices.stateservice.service.model.EmailHistoryResponse;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StateServiceImpl implements StateService {

  private final UserService userService;
  private final EmailHistoryService emailHistoryService;

  @Override
  public EmailHistoryResponse addEmailHistory(Long userId, EmailHistoryPersistRequest request) {
    if (!userService.exists(userId)) {
      throw new RuntimeException("no user %s".formatted(userId));
    }
    EmailHistoryPersistDto persistDto = new EmailHistoryPersistDto();
    persistDto.setUserId(userId);
    persistDto.setRecipientEmail(request.recipientEmail());
    persistDto.setSubject(request.subject());
    persistDto.setMessage(request.message());
    persistDto.setStatus(EmailStatus.CREATED);
    persistDto.setCreatedAt(LocalDateTime.now());
    return emailHistoryService.persist(persistDto);
  }
}
