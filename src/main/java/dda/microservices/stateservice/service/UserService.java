package dda.microservices.stateservice.service;

import dda.microservices.stateservice.service.model.UserUpdateRequest;
import dda.microservices.stateservice.service.model.UserDto;
import java.util.List;

public interface UserService {

  Boolean exists(Long id);

  UserDto createUser(UserDto userDto);

  UserDto getUserById(Long id);

  List<UserDto> getAllUsers();

  UserDto updateUser(Long id, UserUpdateRequest userUpdateRequest);

  UserDto updateEmail(Long id, String newEmail);

  void deleteUser(Long id);
}
