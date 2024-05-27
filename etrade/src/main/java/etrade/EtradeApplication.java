package etrade;

import etrade.business.core.utilities.exceptions.BusinessException;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@SpringBootApplication
public class EtradeApplication {
    public static void main(String[] args) {
        SpringApplication.run(EtradeApplication.class, args);

    }

    @ExceptionHandler
    @ResponseStatus(code= HttpStatus.BAD_REQUEST)
    public BusinessException handleBusinessException(BusinessException businessException){
        BusinessException error = new BusinessException(businessException.getMessage());

        return error;
    }
    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}