package pl.degath.cvgenerator.cvstructure;

import java.time.YearMonth;

public class Certificate {
    private final String name;
    private final String organisation;
    private final YearMonth createdAt;

    public Certificate(String name, String organisation, YearMonth createdAt) {
        this.name = name;
        this.organisation = organisation;
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public String getOrganisation() {
        return organisation;
    }

    public YearMonth getCreatedAt() {
        return createdAt;
    }
}
