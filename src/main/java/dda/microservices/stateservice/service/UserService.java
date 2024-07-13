package dda.microservices.stateservice.service;

import dda.microservices.stateservice.service.model.UserDto;
import java.util.List;

public interface UserService {

  Boolean exist(Long id);

  UserDto createUser(UserDto userDto);

  UserDto getUserById(Long id);

  List<UserDto> getAllUsers();

  UserDto updateUser(Long id, UserDto userDto);

  void deleteUser(Long id);
}
