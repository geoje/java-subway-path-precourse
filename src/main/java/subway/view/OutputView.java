package subway.view;

import subway.constant.GeneralMessage;

import java.util.List;

import static subway.constant.ErrorMessage.EXCEPTION_PREFIX;
import static subway.constant.GeneralMessage.*;

public class OutputView {

    private static void printGeneralMessage(GeneralMessage message, Object... args) {
        System.out.printf(message + "%n", args);
    }

    public static void printErrorMessage(String message) {
        System.out.println(EXCEPTION_PREFIX + message);
    }

    public static void printMain() {
        printGeneralMessage(NOTIFY_MAIN);
        System.out.println();
    }

    public static void printWeightCondition() {
        printGeneralMessage(NOTIFY_WEIGHT_CONDITION);
        System.out.println();
    }

    public static void printResult(int distance, int time, List<String> stations) {
        printGeneralMessage(NOTIFY_RESULT);
        printGeneralMessage(NOTIFY_INFO, NOTIFY_LINE_SEPARATOR.toString());
        printGeneralMessage(NOTIFY_INFO, String.format(NOTIFY_TOTAL_DISTANCE.toString(), distance));
        printGeneralMessage(NOTIFY_INFO, String.format(NOTIFY_TOTAL_TIME.toString(), time));
        printGeneralMessage(NOTIFY_INFO, NOTIFY_LINE_SEPARATOR.toString());
        stations.forEach(station -> {
            printGeneralMessage(NOTIFY_INFO, station);
        });
        System.out.println();
    }
}
