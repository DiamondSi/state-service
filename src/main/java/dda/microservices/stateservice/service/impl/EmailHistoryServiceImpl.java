package dda.microservices.stateservice.service.impl;

import dda.microservices.stateservice.repository.EmailHistoryRepository;
import dda.microservices.stateservice.repository.entity.EmailHistory;
import dda.microservices.stateservice.service.EmailHistoryService;
import dda.microservices.stateservice.service.mapper.EmailHistoryMapper;
import dda.microservices.stateservice.service.model.EmailHistoryDto;
import dda.microservices.stateservice.service.model.EmailHistoryPersistDto;
import dda.microservices.stateservice.service.model.EmailHistoryResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailHistoryServiceImpl implements EmailHistoryService {

  private final EmailHistoryRepository emailHistoryRepository;
  private final EmailHistoryMapper emailHistoryMapper;


  @Override
  public EmailHistoryResponse add(EmailHistoryPersistDto dto) {
    EmailHistory emailHistory = emailHistoryMapper.toEntity(dto);
    EmailHistory savedEntity = emailHistoryRepository.save(emailHistory);

    return emailHistoryMapper.toResponseDto(savedEntity);
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
