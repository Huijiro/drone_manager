package com.dci.drone_manager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor {
    @ExceptionHandler(NoDrone.class)
    public ResponseEntity<ResponseError> handleNoDrone(NoDrone e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseError(e.getMessage()));
    }

    @ExceptionHandler
    public ResponseEntity<ResponseError> noDelivery(NoDelivery e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseError(e.getMessage()));
    }

    @ExceptionHandler(NoField.class)
    public ResponseEntity<ResponseError> handleNoField(NoField e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseError(e.getMessage()));
    }

    @ExceptionHandler(NoDroneAvailable.class)
    public ResponseEntity<ResponseError> handleNoDroneAvailable(NoDroneAvailable e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseError(e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseError> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ResponseError("Erro interno do servidor."));
    }

}
