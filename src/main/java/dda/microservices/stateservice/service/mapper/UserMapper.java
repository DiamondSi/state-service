package dda.microservices.stateservice.service.mapper;

import dda.microservices.stateservice.repository.entity.User;
import dda.microservices.stateservice.service.model.UserDto;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {

  UserDto toDto(User user);

  List<UserDto> toDto(List<User> users);

  User toEntity(UserDto userDto);
}
