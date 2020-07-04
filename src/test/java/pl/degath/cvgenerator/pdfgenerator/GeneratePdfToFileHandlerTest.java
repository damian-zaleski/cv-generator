package pl.degath.cvgenerator.pdfgenerator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pl.degath.cvgenerator.pdfgenerator.commands.GeneratePdfToFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class GeneratePdfToFileHandlerTest {

    private GeneratePdfToFileHandler generatePdfToFileHandler;

    @BeforeEach
    void setUp() {
        generatePdfToFileHandler = new GeneratePdfToFileHandler();
    }

    /**
     * this test generates real pdf file.
     */
    @Test
    @Tag("file-created")
    void handle() {
        Map<String, Object> variables = Map.of("header", "This is test header", "intention", "This is a test intention...");
        var command = new GeneratePdfToFile(variables, "mustache/testTemplate.mustache", "test");

        generatePdfToFileHandler.handle(command);

        assertThat(fileExists()).isTrue();
    }

    private boolean fileExists() {
        return Files.exists(Path.of("test.pdf"));
    }
}