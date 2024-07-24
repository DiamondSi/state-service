package dda.microservices.stateservice.controller;

import dda.microservices.stateservice.service.UserService;
import dda.microservices.stateservice.service.model.UserDto;
import dda.microservices.stateservice.service.model.UserUpdateRequest;
import dda.microservices.stateservice.service.model.UserUpdateResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin/user")
public class UserAdminController {

  private final UserService userService;

  @GetMapping
  public ResponseEntity<List<UserDto>> getAllUsers() {
    List<UserDto> users = userService.getAllUsers();

    return ResponseEntity.ok(users);
  }

  @GetMapping("{id}")
  public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id) {
    UserDto userDto = userService.getUserById(id);

    return ResponseEntity.ok(userDto);
  }

  @PutMapping("{id}")
  public ResponseEntity<UserUpdateResponse> updateUser(@PathVariable("id") Long id,
      @RequestBody UserUpdateRequest userUpdateRequest) {
    UserUpdateResponse response = userService.updateUser(id, userUpdateRequest);

    return ResponseEntity.ok(response);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
    userService.deleteUser(id);

    return ResponseEntity.ok("Deleted user with id %s".formatted(id));
  }

  @Deprecated
  @PostMapping
  public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
    UserDto createdUser = userService.createUser(userDto);

    return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
  }
}
