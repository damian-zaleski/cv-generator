package pl.degath.cvgenerator.pdfgenerator.commands;

import pl.degath.cvgenerator.pdfgenerator.infrastructure.Command;

import java.util.Map;

public class GeneratePdfToFile implements Command {
    private final Map<String, Object> variables;
    private final String mustacheFile;
    private final String pdfFileName;

    public GeneratePdfToFile(Map<String, Object> variables, String mustacheFile, String pdfFileName) {
        this.variables = variables;
        this.mustacheFile = mustacheFile;
        this.pdfFileName = pdfFileName;
    }

    public Map<String, Object> getVariables() {
        return variables;
    }

    public String getMustacheFile() {
        return mustacheFile;
    }

    public String getPdfFileName() {
        return pdfFileName;
    }
}
