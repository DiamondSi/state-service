package dda.microservices.stateservice.service.impl;

import dda.microservices.stateservice.repository.UserRepository;
import dda.microservices.stateservice.service.UserService;
import dda.microservices.stateservice.service.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public UserDto createUser(UserDto userDto) {

    return null;
  }
}
