package pl.degath.cvgenerator.pdfgenerator.infrastructure;

import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.OutputStream;
import java.util.Objects;
import java.util.function.Function;

import static pl.degath.cvgenerator.pdfgenerator.infrastructure.Validator.notBlank;

/**
 * Uses flying saucer to create pdf.
 */
public class CreatePdf implements Function<String, OutputStream> {

    private final OutputStream outputStream;

    public CreatePdf(OutputStream outputStream) {
        this.outputStream = Objects.requireNonNull(outputStream, "Output stream has to be specified.");
    }

    @Override
    public OutputStream apply(String content) {
        notBlank(content, "Content has to be specified (as a valid XHTML).");

        var renderer = new ITextRenderer();
        renderer.setDocumentFromString(content);
        renderer.layout();
        renderer.createPDF(outputStream);
        return outputStream;
    }
}