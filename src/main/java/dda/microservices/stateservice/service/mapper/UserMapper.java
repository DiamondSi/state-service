package dda.microservices.stateservice.service.mapper;

import dda.microservices.stateservice.repository.entity.User;
import dda.microservices.stateservice.service.model.UserDto;
import java.util.List;

public interface UserMapper {
  UserDto toDto(User user);
  List<UserDto> toDto(List<User> users);
}
