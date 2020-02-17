import controller.Controller;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            Controller controller = new Controller();
            controller.executeTask();
            System.out.println("Press 0 to exit.");
            String line = scanner.nextLine();
            if (line.equals("0")) {
                break;
            }
        }
    }
}