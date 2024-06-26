package com.hoxafiy.webservices.User.exception;

import com.hoxafiy.webservices.shared.Messages;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class NotUniqueEmailException extends RuntimeException {
    public NotUniqueEmailException(){
        super(Messages.getMessageForLocale("hoxafiy.error.validation.", LocaleContextHolder.getLocale()));
    }

    public Map<String, String> getValidationErrors(){
        return Collections.singletonMap("email", Messages.getMessageForLocale(
                "hoaxify.constraint.email.notunique",LocaleContextHolder.getLocale()));

    }
}
