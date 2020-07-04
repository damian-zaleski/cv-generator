package pl.degath.cvgenerator.pdfgenerator;

public class XHTMLFixtures {

    private XHTMLFixtures() {
    }

    public static final String contentWhenHeaderAndIntentionSpecified = "<html>\n" +
            "<body>\n" +
            "<h1>This is test header</h1>\n" +
            "<p>This is a test intention...</p>\n" +
            "</body>\n" +
            "</html>";
    public static final String contentWithoutAnyVariables = "<html>\n" +
            "<body>\n" +
            "<h1></h1>\n" +
            "<p></p>\n" +
            "</body>\n" +
            "</html>";
}