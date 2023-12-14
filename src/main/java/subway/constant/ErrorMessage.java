package subway.constant;

public enum ErrorMessage {
    EXCEPTION_PREFIX("[ERROR] "),
    INVALID_FUNCTION("해당 기능은 존재하지 않습니다. 다시 입력해 주세요."),
    INVALID_STATION("해당 역은 존재하지 않습니다. 다시 입력해 주세요."),
    SAME_STATION_DEPART_AND_DEST("출발역과 도착역이 동일합니다. 다시 입력해 주세요."),
    NO_LINE_FOUND("출발역과 도착역이 동일합니다. 다시 입력해 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
