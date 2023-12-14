package subway.constant;

public enum GeneralMessage {
    NOTIFY_XXXX("XXXX"),

    REQUEST_XXXX("XXXX");

    private final String message;

    GeneralMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
