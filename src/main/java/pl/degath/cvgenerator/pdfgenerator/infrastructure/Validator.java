package pl.degath.cvgenerator.pdfgenerator.infrastructure;

import pl.degath.cvgenerator.pdfgenerator.exceptions.ValidationException;

public final class Validator {

    private Validator() {
    }

    public static String notBlank(String value, String message) {
        if (value == null || value.isBlank()) {
            throw new ValidationException(message);
        }
        return value;
    }
}