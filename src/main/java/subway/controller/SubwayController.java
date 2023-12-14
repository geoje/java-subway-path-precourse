package subway.controller;

import subway.constant.MainChoice;
import subway.constant.Station;
import subway.constant.WeightChoice;
import subway.domain.CostMeter;
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

    private MainChoice requestMainChoice() {
        OutputView.printMain();
        return requestUntilValidated(() -> MainChoice.from(inputView.readFunction()));
    }

    private WeightChoice requestWeightChoice() {
        OutputView.printWeightCondition();
        return requestUntilValidated(() -> WeightChoice.from(inputView.readFunction()));
    }

    private Station requestDeparture() {
        return requestUntilValidated(() -> Station.from(inputView.readDeparture()));
    }

    private Station requestDestination() {
        return requestUntilValidated(() -> Station.from(inputView.readDestination()));
    }

    private void notifyResult(CostMeter costMeter) {
        OutputView.printResult(
                costMeter.getTotalDistance(),
                costMeter.getTotalTime(),
                costMeter.getRoute().stream().map(Station::toString).toList()
        );
    }


    public void run() {
        MainChoice mainChoice = requestMainChoice();
        if (mainChoice == MainChoice.QUIT) {
            return;
        }
        WeightChoice weightChoice = requestWeightChoice();
        Station departure = requestDeparture();
        Station destination = requestDestination();

        CostMeter costMeter = new CostMeter(weightChoice, departure, destination);
        notifyResult(costMeter);
    }
}
