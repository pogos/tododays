package pl.pogos.tododays.dto;

/**
 * Created by SG0952928 on 2016-04-12.
 */
public class ErrorDTO {

    private int code;
    private String message;

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
}
