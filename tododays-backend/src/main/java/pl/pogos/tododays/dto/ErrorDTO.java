package pl.pogos.tododays.dto;

import java.io.Serializable;

public class ErrorDTO implements Serializable {

    private int code;
    private String message;

    public ErrorDTO() {
    }

    public ErrorDTO(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ErrorDTO)) return false;

        ErrorDTO errorDTO = (ErrorDTO) o;

        return getCode() == errorDTO.getCode() && (getMessage() != null
                ? getMessage().equals(errorDTO.getMessage()) : errorDTO.getMessage() == null);

    }

    @Override
    public int hashCode() {
        int result = getCode();
        result = 31 * result + (getMessage() != null ? getMessage().hashCode() : 0);
        return result;
    }
}
