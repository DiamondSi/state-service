package dda.microservices.stateservice.service;

import dda.microservices.stateservice.service.model.EmailHistoryDto;
import java.util.List;

public interface EmailHistoryService {

  EmailHistoryDto addEmailHistoryByUserId(Long userId, EmailHistoryDto emailHistoryDto);

  EmailHistoryDto getEmailHistoryById(Long id);

  List<EmailHistoryDto> getEmailHistoriesByUserId(Long userId);

  List<EmailHistoryDto> getAllEmailHistory();

  EmailHistoryDto updateEmailHistory(Long id, EmailHistoryDto emailHistoryDto);

  void deleteEmailHistory(Long id);
}
