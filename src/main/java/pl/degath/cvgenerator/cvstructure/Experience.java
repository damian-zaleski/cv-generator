package pl.degath.cvgenerator.cvstructure;

public class Experience {
    private final String title;
    private final String company;
    private final String location;
    private final DateRange dateRange;
    private final String description;

    public Experience(String title, String company, String location, DateRange dateRange, String description) {
        this.title = title;
        this.company = company;
        this.location = location;
        this.dateRange = dateRange;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getLocation() {
        return location;
    }

    public DateRange getDateRange() {
        return dateRange;
    }

    public String getDescription() {
        return description;
    }
}
