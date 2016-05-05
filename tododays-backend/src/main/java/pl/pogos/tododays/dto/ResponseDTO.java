package pl.pogos.tododays.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ResponseDTO implements Serializable {

    private Set<ErrorDTO> errors;

    public ResponseDTO() {
    }

    public ResponseDTO(ErrorDTO error) {
        addError(error);
    }

    public void addError(ErrorDTO error) {
        if (errors == null) {
            errors = new HashSet<>();
        }
        errors.add(error);
    }

    public Set<ErrorDTO> getErrors() {
        return errors;
    }

    public void setErrors(Set<ErrorDTO> errors) {
        this.errors = errors;
    }
}
