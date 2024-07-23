package dda.microservices.stateservice.controller;

import dda.microservices.stateservice.service.UserService;
import dda.microservices.stateservice.service.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

  private final UserService userService;


  @PutMapping("{id}")
  public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long id,
      @RequestBody String newEmail) {
    UserDto userDto = userService.updateEmail(id, newEmail);

    return ResponseEntity.ok(userDto);
  }

}
