package pl.pogos.tododays.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ResponseDTO implements Serializable {

    private Set<ErrorDTO> errors = new HashSet<>();

    public ResponseDTO() {
    }

    public Set<ErrorDTO> getErrors() {
        return errors;
    }

    public void setErrors(Set<ErrorDTO> errors) {
        this.errors = errors;
    }
}
