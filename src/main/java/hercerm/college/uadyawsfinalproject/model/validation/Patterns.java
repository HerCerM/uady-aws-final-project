package hercerm.college.uadyawsfinalproject.model.validation;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Patterns {

    // Implementation notes:
    // "\\p{L}" identifies all Unicode characters belonging to the 'letter' category.
    // Learn more: http://www.regular-expressions.info/unicode.html#prop

    public static final String NAMES_PATTERN = "^(?!\\s)[\\p{L}\\s]+(?<!\\s)$";
}
