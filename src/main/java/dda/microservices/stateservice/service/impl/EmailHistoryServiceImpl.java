package dda.microservices.stateservice.service.impl;

import dda.microservices.stateservice.repository.EmailHistoryRepository;
import dda.microservices.stateservice.repository.UserRepository;
import dda.microservices.stateservice.repository.entity.EmailHistory;
import dda.microservices.stateservice.repository.entity.User;
import dda.microservices.stateservice.service.EmailHistoryService;
import dda.microservices.stateservice.service.mapper.EmailHistoryMapper;
import dda.microservices.stateservice.service.model.EmailHistoryDto;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailHistoryServiceImpl implements EmailHistoryService {

  private final EmailHistoryRepository emailHistoryRepository;
  private final EmailHistoryMapper emailHistoryMapper;
  private final UserRepository userRepository;

  @Override
  public EmailHistoryDto addEmailHistoryByUserId(Long userId, EmailHistoryDto emailHistoryDto) {
    User user = userRepository.findById(userId).orElse(null);
    EmailHistory emailHistory = emailHistoryMapper.toEntity(emailHistoryDto);
    //TODO разобраться как в этом случае работать с датой новой записи истории
    if (emailHistoryDto.createdAt() == null) {
      emailHistory.setCreatedAt(LocalDateTime.now());
    }
    emailHistory.setUser(user);
    EmailHistory savedEmailHistory = emailHistoryRepository.save(emailHistory);

    return emailHistoryMapper.toDto(savedEmailHistory);
  }

  @Override
  public EmailHistoryDto getEmailHistoryById(Long id) {
    return null;
  }

  @Override
  public List<EmailHistoryDto> getEmailHistoriesByUserId(Long userId) {
    return List.of();
  }

  @Override
  public List<EmailHistoryDto> getAllEmailHistory() {
    return List.of();
  }

  @Override
  public EmailHistoryDto updateEmailHistory(Long id, EmailHistoryDto emailHistoryDto) {
    return null;
  }

  @Override
  public void deleteEmailHistory(Long id) {

  }
}
