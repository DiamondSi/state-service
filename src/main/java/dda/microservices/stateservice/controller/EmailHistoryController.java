package dda.microservices.stateservice.controller;

import dda.microservices.stateservice.service.EmailHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/email-history")
public class EmailHistoryController {

  private final EmailHistoryService emailHistoryService;
//
//  @PostMapping("/user/{id}")
//  public ResponseEntity<EmailHistoryPersistRequest> addHistory(@PathVariable("id") Long userId,
//      @RequestBody EmailHistoryDto emailHistoryDto) {
//    EmailHistoryDto addedEmailHistory = emailHistoryService.addEmailHistoryByUserId(userId,
//        emailHistoryDto);
//
//    return new ResponseEntity<>(addedEmailHistory, HttpStatus.CREATED);
//  }
}
