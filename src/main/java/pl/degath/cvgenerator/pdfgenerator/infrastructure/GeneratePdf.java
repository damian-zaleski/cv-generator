package pl.degath.cvgenerator.pdfgenerator.infrastructure;

import java.util.Map;
import java.util.function.BiConsumer;

public class GeneratePdf implements BiConsumer<Map<String, Object>, String> {
    private final ParseToXHTML parseToXHTML;
    private final CreatePdf createPdf;

    public GeneratePdf(ParseToXHTML parseToXHTML, CreatePdf createPdf) {
        this.parseToXHTML = parseToXHTML;
        this.createPdf = createPdf;
    }

    @Override
    public void accept(Map<String, Object> variables, String mustacheFile) {
        String content = parseToXHTML.apply(variables, mustacheFile);
        createPdf.apply(content);
    }
}
