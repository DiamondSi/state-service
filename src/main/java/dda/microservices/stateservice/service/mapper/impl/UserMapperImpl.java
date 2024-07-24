package dda.microservices.stateservice.service.mapper.impl;

import dda.microservices.stateservice.repository.entity.EmailHistory;
import dda.microservices.stateservice.repository.entity.User;
import dda.microservices.stateservice.service.mapper.EmailHistoryMapper;
import dda.microservices.stateservice.service.mapper.UserMapper;
import dda.microservices.stateservice.service.model.EmailHistoryDto;
import dda.microservices.stateservice.service.model.UserDto;
import dda.microservices.stateservice.service.model.UserUpdateResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapperImpl implements UserMapper {

  private final EmailHistoryMapper emailHistoryMapper;

  @Override
  public UserDto toDto(User user) {
    if (user == null) {
      return null;
    }
    List<EmailHistory> histories = user.getEmailHistories();
    List<EmailHistoryDto> historyDtos = null;
    if (histories != null && !histories.isEmpty()) {
      historyDtos = histories.stream()
          .map(emailHistoryMapper::toDto)
          .toList();
    }

    return new UserDto(user.getId(), user.getEmail(), user.getUsername(), historyDtos);
  }


  @Override
  public List<UserDto> toDto(List<User> users) {
    return users.stream().map(this::toDto).toList();
  }

  @Override
  public User toEntity(UserDto dto) {
    if (dto == null) {
      return null;
    }
    User user = new User();
    user.setEmail(dto.email());
    user.setUsername(dto.username());

    return user;
  }

  @Override
  public UserUpdateResponse toUpdateResponse(User user) {
    if (user == null) {
      return null;
    }

    return new UserUpdateResponse(user.getId(), user.getEmail(), user.getUsername());
  }
}
