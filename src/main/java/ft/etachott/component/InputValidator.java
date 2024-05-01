package ft.etachott.component;

import java.util.Set;

public class InputValidator {
    private InputValidator() {}

    public static void validateCharacterCreationInput(String[] input) throws IllegalArgumentException {
        Set<String> validClasses = Set.of("netrunner", "techie", "nomad");
        if (input == null || input.length != 2
                || input[0] == null || input[1] == null
                || input[0].isEmpty() || input[1].isEmpty()) {
            throw new IllegalArgumentException("Empty input.");
        }
        String characterClass = input[1];
        if (!validClasses.contains(characterClass)) {
            throw new IllegalArgumentException("Invalid character class: " + characterClass);
        }
    }
}
