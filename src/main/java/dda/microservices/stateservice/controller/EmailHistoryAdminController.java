package dda.microservices.stateservice.controller;

import dda.microservices.stateservice.service.EmailHistoryService;
import dda.microservices.stateservice.service.model.EmailHistoryDto;
import dda.microservices.stateservice.service.model.EmailHistoryUpdateRequest;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin/email-history")
public class EmailHistoryAdminController {

  private final EmailHistoryService emailHistoryService;

  @GetMapping
  public ResponseEntity<List<EmailHistoryDto>> getAllEmailHistories() {
    List<EmailHistoryDto> histories = emailHistoryService.getAllEmailHistory();
    return ResponseEntity.ok(histories);
  }

  @GetMapping("{id}")
  public ResponseEntity<EmailHistoryDto> getEmailHistoryById(@PathVariable("id") Long id) {
    EmailHistoryDto emailHistoryDto = emailHistoryService.getEmailHistoryById(id);
    return ResponseEntity.ok(emailHistoryDto);
  }

  @PutMapping("{id}")
  public ResponseEntity<EmailHistoryDto> updateEmailHistory(@PathVariable("id") Long id,
      @RequestBody EmailHistoryUpdateRequest emailHistoryUpdateRequest) {
    EmailHistoryDto emailHistoryDto = emailHistoryService.updateEmailHistory(id,
        emailHistoryUpdateRequest);
    return ResponseEntity.ok(emailHistoryDto);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<String> deleteEmailHistory(@PathVariable("id") Long id) {
    emailHistoryService.deleteEmailHistory(id);
    return ResponseEntity.ok("Deleted emailHistory with id %s".formatted(id));
  }
}
