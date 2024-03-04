package ft.etachott;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java -jar swingy.jar [console | gui]");
        }
        if (Objects.equals(args[0], "console")) {
            System.out.println("console");
        } else if (Objects.equals(args[0], "gui")) {
            System.out.println("gui!");
        }

    }
}