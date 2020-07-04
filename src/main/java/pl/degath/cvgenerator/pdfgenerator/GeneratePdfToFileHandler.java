package pl.degath.cvgenerator.pdfgenerator;

import pl.degath.cvgenerator.pdfgenerator.commands.GeneratePdfToFile;
import pl.degath.cvgenerator.pdfgenerator.exceptions.PdfGeneratorException;
import pl.degath.cvgenerator.pdfgenerator.infrastructure.CommandHandler;
import pl.degath.cvgenerator.pdfgenerator.infrastructure.CreatePdf;
import pl.degath.cvgenerator.pdfgenerator.infrastructure.GeneratePdf;
import pl.degath.cvgenerator.pdfgenerator.infrastructure.ParseToXHTML;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import static pl.degath.cvgenerator.pdfgenerator.infrastructure.Validator.notBlank;

public class GeneratePdfToFileHandler implements CommandHandler<GeneratePdfToFile> {

    @Override
    public void handle(GeneratePdfToFile command) {
        //todo https://github.com/degath/cv-generator/issues/10
        notBlank(command.getPdfFileName(), "Pdf file name has to be specified.");

        var createXHTMLContent = new ParseToXHTML();
        var outputStream = outputStream(command);
        var createPdf = new CreatePdf(outputStream);
        var generatePdf = new GeneratePdf(createXHTMLContent, createPdf);

        generatePdf.accept(command.getVariables(), command.getMustacheFile());
    }

    private FileOutputStream outputStream(GeneratePdfToFile command) {
        FileOutputStream outputStream;
        try {
            outputStream = new FileOutputStream(command.getPdfFileName() + ".pdf");
        } catch (FileNotFoundException e) {
            throw new PdfGeneratorException(e.getMessage());
        }
        return outputStream;
    }
}