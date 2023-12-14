package subway;

import subway.controller.SubwayController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final SubwayController controller = new SubwayController(scanner);
        controller.run();
    }
}
