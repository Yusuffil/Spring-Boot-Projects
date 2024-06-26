package com.hoxafiy.webservices.User;

import com.hoxafiy.webservices.User.dto.UserCreate;
import com.hoxafiy.webservices.User.exception.NotUniqueEmailException;
import com.hoxafiy.webservices.error.ApiError;
import com.hoxafiy.webservices.shared.GenericMessage;
import com.hoxafiy.webservices.shared.Messages;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
public class UsersController {

    @Autowired
    private UserService userService;



    @PostMapping("/api/v1/users")
    GenericMessage createUser(@RequestBody @Valid UserCreate userCreate) {
        userService.save(userCreate.toUser());
        String message = Messages.getMessageForLocale("hoaxify.create.user.success.message",LocaleContextHolder.getLocale());
        return new GenericMessage(message);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        var apiError = new ApiError();
        String message = Messages.getMessageForLocale("hoaxify.error.validation",LocaleContextHolder.getLocale());
        apiError.setPath("/api/v1/users");
        apiError.setMessage(message);
        apiError.setStatus(400);


        /*Map<String,String> validationErrors = new HashMap<>();

        for(var fieldError : exception.getBindingResult().getFieldErrors()){

            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }*/


        var validationErrors = exception.getBindingResult().getFieldErrors().stream().collect(Collectors.toMap(
                FieldError::getField,FieldError::getDefaultMessage, (existing,replacing)-> replacing));
        apiError.setValidationErrors(validationErrors);
        return ResponseEntity.badRequest().body(apiError);
    }

    @ExceptionHandler(NotUniqueEmailException.class)
    ResponseEntity<ApiError> handleNotUniqueEmailException(NotUniqueEmailException exception) {
        var apiError = new ApiError();
        apiError.setPath("/api/v1/users");
        apiError.setMessage(exception.getMessage());
        apiError.setStatus(400);
        apiError.setValidationErrors(exception.getValidationErrors());
        return ResponseEntity.badRequest().body(apiError);
    }

}
