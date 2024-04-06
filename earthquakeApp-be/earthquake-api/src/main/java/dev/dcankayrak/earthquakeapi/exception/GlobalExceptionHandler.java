package dev.dcankayrak.earthquakeapi.exception;

import dev.dcankayrak.earthquakeapi.core.results.ErrorDataResult;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final MessageSource messageSource;

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<ErrorDataResult<ErrorResponse>> handleGenericException(GenericException ex) {
        String errorMessage = messageSource.getMessage(ex.getErrorEnum().getMessageTemplate(), null, LocaleContextHolder.getLocale());
        ErrorResponse errorResponse = ErrorResponse
                .builder(ex, ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(400),errorMessage))
                .build();

        ErrorDataResult<ErrorResponse> response = new ErrorDataResult<>(errorResponse,messageSource.getMessage("exception",null,LocaleContextHolder.getLocale()));
        return new ResponseEntity<>(response,response.data.getStatusCode());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDataResult<Map<String, String>>> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });
        ErrorDataResult<Map<String, String>> response = new ErrorDataResult<>(errors,messageSource.getMessage("exception",null,LocaleContextHolder.getLocale()));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
