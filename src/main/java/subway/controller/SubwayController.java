package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;
import java.util.function.Supplier;

public class SubwayController {
    private final InputView inputView;

    public SubwayController(Scanner scanner) {
        inputView = new InputView(scanner);
    }

    private static <T> T requestUntilValidated(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public void run() {
        OutputView.printMain();
        inputView.readFunction();
        OutputView.printWeightCondition();
        inputView.readFunction();
        // TODO: Enum 클래스로 메인 함수 결과와 가중치 선택을 만들고 해당 자료형으로 진행
    }
}
