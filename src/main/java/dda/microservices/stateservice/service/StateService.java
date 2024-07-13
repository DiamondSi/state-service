package dda.microservices.stateservice.service;

import dda.microservices.stateservice.service.model.EmailHistoryPersistRequest;
import dda.microservices.stateservice.service.model.EmailHistoryResponse;

public interface StateService {

  EmailHistoryResponse addEmailHistory(Long userId, EmailHistoryPersistRequest request);
}
