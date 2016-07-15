package pl.pogos.tododays.util;

import pl.pogos.tododays.dto.ErrorDTO;

public class ErrorHelper {

    public enum ErrorType {
        USER_ALREADY_EXISTS(1, "User {0} already exists"),
        CATEGORY_ALREADY_EXISTS(2, "Category {0} already exists"),
        TASK_ALREADY_EXISTS(3, "Category already exists"),
        TAG_ALREADY_EXISTS(4, "Category already exists");

        private final int code;
        private final String message;

        ErrorType(int code, String message) {
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

    public static ErrorDTO getError(ErrorType errorType) {
        return new ErrorDTO(errorType.getCode(), errorType.getMessage());
    }
}
