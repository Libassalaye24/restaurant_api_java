package com.restaurantapi.resrtaurantapi.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class CommandeGlobalExceptionHandler extends GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(value = {PaiementException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handleException(PaiementException orderDomainException){
//        log.error(orderDomainException.getMessage(), orderDomainException);
//        return ErrorDTO.builder()
//                .code(HttpStatus.NOT_FOUND.getReasonPhrase())
//                .message(orderDomainException.getMessage())
//                .build();
        return new ErrorDTO(HttpStatus.NOT_FOUND.getReasonPhrase() ,orderDomainException.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = {CommandeNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handleException(CommandeNotFoundException orderNotFoundException){
//        log.error(orderNotFoundException.getMessage(), orderNotFoundException);
//        return ErrorDTO.builder()
//                .code(HttpStatus.NOT_FOUND.getReasonPhrase())
//                .message(orderNotFoundException.getMessage())
//                .build();
        return new ErrorDTO(HttpStatus.NOT_FOUND.getReasonPhrase() ,orderNotFoundException.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = {CommandeException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDTO handleException(CommandeException orderNotFoundException){
//        log.error(orderNotFoundException.getMessage(), orderNotFoundException);
//        return ErrorDTO.builder()
//                .code(HttpStatus.OK.getReasonPhrase())
//                .message(orderNotFoundException.getMessage())
//                .build();
        return new ErrorDTO(HttpStatus.OK.getReasonPhrase() ,orderNotFoundException.getMessage());
    }
}
