package pl.degath.cvgenerator.pdfgenerator.infrastructure;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import pl.degath.cvgenerator.pdfgenerator.exceptions.PdfGeneratorException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;
import java.util.function.BiFunction;

import static pl.degath.cvgenerator.pdfgenerator.infrastructure.Validator.notBlank;

/**
 * Uses Mustache to create a string with XHTML.
 */
public class ParseToXHTML implements BiFunction<Map<String, Object>, String, String> {

    private final MustacheFactory mustacheFactory = new DefaultMustacheFactory();

    @Override
    public String apply(Map<String, Object> variables, String mustacheFile) {
        //todo https://github.com/degath/cv-generator/issues/11
        notBlank(mustacheFile, "Template has to be specified.");

        Mustache mustache = mustacheFactory.compile(mustacheFile);
        StringWriter stringWriter = new StringWriter();
        Writer mustacheWriter = mustache.execute(stringWriter, variables);
        flushMustache(mustacheWriter);
        return stringWriter.toString();
    }

    private void flushMustache(Writer mustacheWriter) {
        try {
            mustacheWriter.flush();
        } catch (IOException e) {
            throw new PdfGeneratorException(e.getMessage());
        }
    }
}
