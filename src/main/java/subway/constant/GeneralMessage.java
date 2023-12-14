package subway.constant;

public enum GeneralMessage {
    NOTIFY_MAIN("## 메인 화면\n1. 경로 조회\nQ. 종료"),
    NOTIFY_WEIGHT_CONDITION("## 경로 기준\n1. 최단 거리\n2. 최소 시간\nB. 돌아가기"),
    NOTIFY_RESULT("## 조회 결과"),
    NOTIFY_INFO("[INFO] %s"),
    NOTIFY_LINE_SEPARATOR("---"),
    NOTIFY_TOTAL_DISTANCE("총 거리: %dkm"),
    NOTIFY_TOTAL_TIME("총 소요 시간: %d분"),

    REQUEST_FUNCTION("## 원하는 기능을 선택하세요."),
    REQUEST_DEPARTURE("## 출발역을 입력하세요."),
    REQUEST_DESTINATION("## 도착역을 입력하세요.");

    private final String message;

    GeneralMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
