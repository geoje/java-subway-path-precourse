package subway.view;

import subway.constant.GeneralMessage;

import static subway.constant.ErrorMessage.EXCEPTION_PREFIX;
import static subway.constant.GeneralMessage.NOTIFY_MAIN;
import static subway.constant.GeneralMessage.NOTIFY_WEIGHT_CONDITION;

public class OutputView {

    private static void printGeneralMessage(GeneralMessage message, Object... args) {
        System.out.printf(message + "%n", args);
    }

    public static void printErrorMessage(String message) {
        System.out.println(EXCEPTION_PREFIX + message);
    }

    public static void printMain() {
        printGeneralMessage(NOTIFY_MAIN);
    }

    public static void printWeightCondition() {
        printGeneralMessage(NOTIFY_WEIGHT_CONDITION);
    }
}
