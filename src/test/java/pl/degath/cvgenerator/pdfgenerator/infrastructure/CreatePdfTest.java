package pl.degath.cvgenerator.pdfgenerator.infrastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.degath.cvgenerator.pdfgenerator.XHTMLFixtures;
import pl.degath.cvgenerator.pdfgenerator.exceptions.ValidationException;

import java.io.ByteArrayOutputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@ExtendWith(MockitoExtension.class)
class CreatePdfTest {

    private CreatePdf createPdf;

    @BeforeEach
    void setUp() {
        createPdf = new CreatePdf(new ByteArrayOutputStream());
    }

    @Test
    void createsPdf() {
        var output = createPdf.apply(XHTMLFixtures.contentWhenHeaderAndIntentionSpecified);

        assertThat(output.toString())
                .contains("PDF-1.5")
                .contains("This is test header");
    }


    @Test
    void cannotCreatePdfWhenContentIsMissing() {
        Throwable thrown = catchThrowable(() ->
                createPdf.apply(null));

        assertThat(thrown)
                .isInstanceOf(ValidationException.class)
                .hasMessageContaining("Content has to be specified (as a valid XHTML).");
    }


    @ParameterizedTest
    @ValueSource(strings = {"", "            "})
    void cannotCreatePdfWhenContentIsBlank(String input) {
        Throwable thrown = catchThrowable(() ->
                createPdf.apply(input));

        assertThat(thrown)
                .isInstanceOf(ValidationException.class)
                .hasMessageContaining("Content has to be specified (as a valid XHTML).");
    }
}
