package pl.degath.cvgenerator.cvstructure;

public class DateRange {
    private final String start;
    private final String end;

    public DateRange(String start, String end) {
        this.start = start;
        this.end = end;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }
}