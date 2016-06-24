package pl.pogos.tododays.handler;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.pogos.tododays.dto.ErrorDTO;
import pl.pogos.tododays.dto.ResponseDTO;

import java.util.List;

//TODO add test for handler
@ControllerAdvice
public class RestErrorHandler {

    //TODO localized error messages
    //private MessageSource messageSource;


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseDTO handleValidationError(MethodArgumentNotValidException ex) {
        final ResponseDTO response = new ResponseDTO();

        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        for (FieldError fieldError: fieldErrors) {
            final ErrorDTO error = new ErrorDTO(0, "Validation error: " + fieldError.getField() + " / " + fieldError.getRejectedValue());
            response.addError(error);
        }
        return response;
    }

}
