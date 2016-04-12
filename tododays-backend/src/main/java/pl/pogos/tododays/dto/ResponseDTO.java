package pl.pogos.tododays.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by SG0952928 on 2016-04-12.
 */
public class ResponseDTO implements Serializable {

    private Set<ErrorDTO> errors = new HashSet<ErrorDTO>();

    public ResponseDTO() {
    }

    public Set<ErrorDTO> getErrors() {
        return errors;
    }

    public void setErrors(Set<ErrorDTO> errors) {
        this.errors = errors;
    }
}
