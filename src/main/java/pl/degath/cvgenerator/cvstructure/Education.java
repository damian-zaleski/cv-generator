package pl.degath.cvgenerator.cvstructure;

public class Education {
    private final String school;
    private final String degree;
    private final String fieldOfStudy;
    private final DateRange dateRange;

    public Education(String school, String degree, String fieldOfStudy, DateRange dateRange) {
        this.school = school;
        this.degree = degree;
        this.fieldOfStudy = fieldOfStudy;
        this.dateRange = dateRange;
    }

    public String getSchool() {
        return school;
    }

    public String getDegree() {
        return degree;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public DateRange getDateRange() {
        return dateRange;
    }
}
