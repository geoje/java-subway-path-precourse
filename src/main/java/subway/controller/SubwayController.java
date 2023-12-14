package subway.controller;

import subway.constant.MainChoice;
import subway.constant.WeightChoice;
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
        MainChoice mainChoice = requestMainChoice();
        WeightChoice weightChoice = requestWeightChoice();
    }

    public MainChoice requestMainChoice() {
        OutputView.printMain();
        return requestUntilValidated(() -> MainChoice.from(inputView.readFunction()));
    }

    public WeightChoice requestWeightChoice() {
        OutputView.printWeightCondition();
        return requestUntilValidated(() -> WeightChoice.from(inputView.readFunction()));
    }
}
