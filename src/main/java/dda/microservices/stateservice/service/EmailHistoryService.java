package dda.microservices.stateservice.service;

import dda.microservices.stateservice.service.model.EmailHistoryDto;
import dda.microservices.stateservice.service.model.EmailHistoryPersistDto;
import dda.microservices.stateservice.service.model.EmailHistoryResponse;
import dda.microservices.stateservice.service.model.EmailHistoryUpdateRequest;
import java.util.List;

public interface EmailHistoryService {
  EmailHistoryResponse persist(EmailHistoryPersistDto dto);

  EmailHistoryDto getEmailHistoryById(Long id);

  List<EmailHistoryDto> getEmailHistoriesByUserId(Long userId);

  List<EmailHistoryDto> getAllEmailHistory();

  EmailHistoryDto updateEmailHistory(Long id, EmailHistoryUpdateRequest emailHistoryUpdateRequest);

  void deleteEmailHistory(Long id);
}
