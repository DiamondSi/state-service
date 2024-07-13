package dda.microservices.stateservice.controller;

import dda.microservices.stateservice.service.StateService;
import dda.microservices.stateservice.service.model.EmailHistoryPersistRequest;
import dda.microservices.stateservice.service.model.EmailHistoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/state")
@RequiredArgsConstructor
public class StateController {

  private final StateService stateService;

  @PostMapping("/user/{userId}")
  public ResponseEntity<EmailHistoryResponse> persistState(@PathVariable Long userId,
      @RequestBody EmailHistoryPersistRequest request) {
    return ResponseEntity.ok(stateService.addEmailHistory(userId, request));
  }
}
