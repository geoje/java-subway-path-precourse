package subway.view;

import subway.constant.GeneralMessage;

import java.util.Scanner;

import static subway.constant.GeneralMessage.REQUEST_FUNCTION;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    private String readWithGeneralMessage(GeneralMessage message, Object... args) {
        System.out.printf(message.toString() + "%n", args);
        String result = scanner.nextLine().trim();
        System.out.println();
        return result;
    }

    public String readFunction() {
        return readWithGeneralMessage(REQUEST_FUNCTION);
    }
}
