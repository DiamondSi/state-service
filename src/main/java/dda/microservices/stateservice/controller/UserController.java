package dda.microservices.stateservice.controller;

import dda.microservices.stateservice.service.UserService;
import dda.microservices.stateservice.service.model.UserEmailUpdateRequest;
import dda.microservices.stateservice.service.model.UserUpdateResponse;
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
  public ResponseEntity<UserUpdateResponse> updateUser(@PathVariable("id") Long id,
      @RequestBody UserEmailUpdateRequest request) {
    UserUpdateResponse response = userService.updateEmail(id, request);

    return ResponseEntity.ok(response);
  }

}
