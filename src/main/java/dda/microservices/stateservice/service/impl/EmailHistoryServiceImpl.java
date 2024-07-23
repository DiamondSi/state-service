package dda.microservices.stateservice.service.impl;

import dda.microservices.stateservice.repository.EmailHistoryRepository;
import dda.microservices.stateservice.repository.entity.EmailHistory;
import dda.microservices.stateservice.service.EmailHistoryService;
import dda.microservices.stateservice.service.mapper.EmailHistoryMapper;
import dda.microservices.stateservice.service.model.EmailHistoryDto;
import dda.microservices.stateservice.service.model.EmailHistoryPersistDto;
import dda.microservices.stateservice.service.model.EmailHistoryResponse;
import dda.microservices.stateservice.service.model.EmailHistoryUpdateRequest;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailHistoryServiceImpl implements EmailHistoryService {

  private final EmailHistoryRepository emailHistoryRepository;
  private final EmailHistoryMapper emailHistoryMapper;
  private final UserServiceImpl userService;


  @Override
  public EmailHistoryResponse persist(EmailHistoryPersistDto dto) {
    EmailHistory emailHistory = emailHistoryMapper.toEntity(dto);
    EmailHistory savedEntity = emailHistoryRepository.save(emailHistory);

    return emailHistoryMapper.toResponseDto(savedEntity);
  }

  @Override
  public EmailHistoryDto getEmailHistoryById(Long id) {
    EmailHistory emailHistory = emailHistoryRepository.findById(id)
        .orElseThrow(
            () -> new EntityNotFoundException("Email History with id %s not Found".formatted(id)));

    return emailHistoryMapper.toDto(emailHistory);
  }

  @Override
  public List<EmailHistoryDto> getEmailHistoriesByUserId(Long userId) {
    return userService.getUserById(userId).emailHistories();
  }

  @Override
  public List<EmailHistoryDto> getAllEmailHistory() {
    List<EmailHistory> histories = emailHistoryRepository.findAll();

    return histories.stream().map(emailHistoryMapper::toDto).toList();
  }

  @Override
  public EmailHistoryDto updateEmailHistory(Long id, EmailHistoryUpdateRequest emailHistoryUpdateRequest) {
    EmailHistory emailHistory = emailHistoryRepository.findById(id)
        .orElseThrow(
            () -> new EntityNotFoundException("Email History with id %s not Found".formatted(id)));
    emailHistory.setRecipientEmail(emailHistoryUpdateRequest.recipientEmail());
    emailHistory.setSubject(emailHistoryUpdateRequest.subject());
    emailHistory.setStatus(emailHistoryUpdateRequest.status());
    EmailHistory savedEmailHistory = emailHistoryRepository.save(emailHistory);
    return emailHistoryMapper.toDto(savedEmailHistory);
  }

  @Override
  public void deleteEmailHistory(Long id) {
    EmailHistory emailHistory = emailHistoryRepository.findById(id).orElseThrow(
        () -> new EntityNotFoundException("Email History with id %s not Found".formatted(id)));

    emailHistoryRepository.delete(emailHistory);
  }
}
