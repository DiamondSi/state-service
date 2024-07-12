package dda.microservices.stateservice.service;

import dda.microservices.stateservice.service.model.UserDto;

public interface UserService {
UserDto createUser(UserDto userDto);
}
