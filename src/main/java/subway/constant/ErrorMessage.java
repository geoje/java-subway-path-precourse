package subway.constant;

public enum ErrorMessage {
    EXCEPTION_PREFIX("[ERROR] "),
    XXXX("XXXX");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
