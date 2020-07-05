package pl.degath.cvgenerator;

import pl.degath.cvgenerator.cvstructure.*;
import pl.degath.cvgenerator.pdfgenerator.GeneratePdfToFileHandler;
import pl.degath.cvgenerator.pdfgenerator.commands.GeneratePdfToFile;

import java.time.YearMonth;
import java.util.List;
import java.util.Map;

public class CvGeneratorApp {

    public static void main(String[] args) {
        var generatePdfToFileHandler = new GeneratePdfToFileHandler();
        generatePdfToFileHandler.handle(
                new GeneratePdfToFile(
                        cvVariables(),
                        "mustache/cvTemplate.mustache",
                        "my-cv"
                )
        );
    }

    private static Map<String, Object> cvVariables() {
        return Map.of(
                "personDetail", personDetails(),
                "footer", "Here I write that I accept personal data processing (rodo etc).");
    }

    private static PersonDetail personDetails() {
        return new PersonDetail(new FullName("Damian", "Zaleski"),
                "Gdansk",
                "phone-boilerplate",
                "zaleskid1@gmail.com",
                "Software developer with 3+ years of experience. " +
                        "Huge enthusiast of unit testing and valuable code reviews.",
                List.of(
                        new Skill("Java"),
                        new Skill("Spring"),
                        new Skill("Rest"),
                        new Skill("Hibernate"),
                        new Skill("GIT"),
                        new Skill("Maven/Gradle")
                ),
                List.of(
                        new Experience("Software Developer", "Finestmedia", "Gdansk", new DateRange("Jan 2020", "now"), "International private sector (IoT Cloud - managed IoT services, Education - school management system)"),
                        new Experience("Software Developer", "netcompany", "Warsaw", new DateRange("Feb 2019", "Nov 2019"), "Danish public sector (Forestry - nature areas management, Taxes - Digitization of Corporate Tax)"),
                        new Experience("Junior Java developer", "Softy Labs Sp. z o.o.", "Koszalin", new DateRange("Nov 2017", "Jan 2019"), "Managament - Employee management application"),
                        new Experience("Internship Student", "Softy Labs Sp. z o.o.", "Koszalin", new DateRange("Jul 2016", "Sep 2016"), "Automotive - Speech module in premium class cars")
                ),
                List.of(
                        new Education("Koszalin University of Technology", "Master of Computer Science", "Computer Science", new DateRange("2016", "2017")),
                        new Education("Koszalin University of Technology", "Bachelor of Computer Science", "Computer Science", new DateRange("2012", "2016"))
                ),
                List.of(
                        new Certificate("TOEIC L&R (english cert. B2)", "Educational Testing Service (ETS)", YearMonth.of(2016, 11))
                ),
                List.of(
                        new Link("linkedin", "https://linkedin.com/in/damian-zaleski"),
                        new Link("github", "https://github.com/degath")
                ));
    }
}
