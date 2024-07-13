package dda.microservices.stateservice.controller;

import dda.microservices.stateservice.service.EmailHistoryService;
import dda.microservices.stateservice.service.model.EmailHistoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/email-history")
public class EmailHistoryController {

  private final EmailHistoryService emailHistoryService;

  @PostMapping("{id}")
  public ResponseEntity<EmailHistoryDto> addHistory(@PathVariable("id") Long userId,
      @RequestBody EmailHistoryDto emailHistoryDto) {
    EmailHistoryDto addedEmailHistory = emailHistoryService.addEmailHistoryByUserId(userId,
        emailHistoryDto);

    return new ResponseEntity<>(addedEmailHistory, HttpStatus.CREATED);
  }
}
