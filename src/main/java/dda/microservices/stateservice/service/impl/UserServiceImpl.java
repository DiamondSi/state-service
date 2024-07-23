package dda.microservices.stateservice.service.impl;

import dda.microservices.stateservice.repository.UserRepository;
import dda.microservices.stateservice.repository.entity.User;
import dda.microservices.stateservice.service.UserService;
import dda.microservices.stateservice.service.mapper.UserMapper;
import dda.microservices.stateservice.service.model.UserDto;
import dda.microservices.stateservice.service.model.UserUpdateRequest;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;

  @Override
  public Boolean exists(Long id) {
    return userRepository.existsById(id);
  }

  @Override
  public UserDto createUser(UserDto userDto) {
    User user = userMapper.toEntity(userDto);
    User savedUser = userRepository.save(user);

    return userMapper.toDto(savedUser);
  }

  @Override
  public UserDto getUserById(Long id) {
    User user = userRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("User with id %s not found".formatted(id)));

    return userMapper.toDto(user);
  }

  @Override
  public List<UserDto> getAllUsers() {
    List<User> users = userRepository.findAll();

    return userMapper.toDto(users);
  }

  @Override
  public UserDto updateUser(Long id, UserUpdateRequest userUpdateRequest) {
    User user = userRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("User with id %s not found".formatted(id)));
    user.setEmail(userUpdateRequest.email());
    user.setUsername(userUpdateRequest.username());
    User udatedUser = userRepository.save(user);

    return userMapper.toDto(udatedUser);
  }

  @Override
  public UserDto updateEmail(Long id, String newEmail) {
    User user = userRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("User with id %s not found".formatted(id)));
    user.setEmail(newEmail);
    User udatedUser = userRepository.save(user);

    return userMapper.toDto(udatedUser);
  }

  @Override
  public void deleteUser(Long id) {
    User user = userRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("User with id %s not found".formatted(id)));

    userRepository.delete(user);
  }

}
