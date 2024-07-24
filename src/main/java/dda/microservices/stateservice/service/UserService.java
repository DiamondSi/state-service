package dda.microservices.stateservice.service;

import dda.microservices.stateservice.service.model.UserDto;
import dda.microservices.stateservice.service.model.UserEmailUpdateRequest;
import dda.microservices.stateservice.service.model.UserUpdateRequest;
import dda.microservices.stateservice.service.model.UserUpdateResponse;
import java.util.List;

public interface UserService {

  Boolean exists(Long id);

  UserDto createUser(UserDto userDto);

  UserDto getUserById(Long id);

  List<UserDto> getAllUsers();

  UserUpdateResponse updateUser(Long id, UserUpdateRequest userUpdateRequest);

  UserUpdateResponse updateEmail(Long id, UserEmailUpdateRequest userEmailUpdateRequest);

  void deleteUser(Long id);
}
