package pl.degath.cvgenerator.pdfgenerator.infrastructure;

import com.github.mustachejava.MustacheNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pl.degath.cvgenerator.pdfgenerator.XHTMLFixtures;
import pl.degath.cvgenerator.pdfgenerator.exceptions.ValidationException;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParseToXHTMLTest {

    private ParseToXHTML parseToXHTML;

    @BeforeEach
    void setUp() {
        parseToXHTML = new ParseToXHTML();
    }

    @Test
    void parsesFilledXHTMLContentWhenValidInputs() {
        var givenVariables = new HashMap<String, Object>();
        givenVariables.put("header", "This is test header");
        givenVariables.put("intention", "This is a test intention...");

        String result = parseToXHTML.apply(givenVariables, "mustache/testTemplate.mustache");

        assertThat(result)
                .isEqualTo(XHTMLFixtures.contentWhenHeaderAndIntentionSpecified);
    }

    @Test
    void parsesEmptyXHTMLContentWhenMissingVariables() {
        String result = parseToXHTML.apply(null, "mustache/testTemplate.mustache");

        assertThat(result)
                .isEqualTo(XHTMLFixtures.contentWithoutAnyVariables);
    }

    @Test
    void cannotParseWhenTemplateDoesNotExist() {
        assertThatThrownBy(() -> parseToXHTML.apply(null, "not-existing.mustache"))
                .isInstanceOf(MustacheNotFoundException.class)
                .hasMessageContaining("Template not-existing.mustache not found");
    }

    @Test
    void cannotParseWhenTemplateIsMissing() {
        assertThatThrownBy(() -> parseToXHTML.apply(null, null))
                .isInstanceOf(ValidationException.class)
                .hasMessageContaining("Template has to be specified.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "            "})
    void cannotParseWhenTemplateIsBlank(String input) {
        assertThatThrownBy(() -> parseToXHTML.apply(null, input))
                .isInstanceOf(ValidationException.class)
                .hasMessageContaining("Template has to be specified.");
    }
}