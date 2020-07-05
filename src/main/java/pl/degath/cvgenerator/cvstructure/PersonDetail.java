package pl.degath.cvgenerator.cvstructure;

import java.util.List;

public class PersonDetail {
    private final FullName fullName;
    private final String city;
    private final String phoneNumber;
    private final String email;
    private final String summaryAboutMe;
    private final List<Skill> skills;
    private final List<Experience> experiences;
    private final List<Education> educations;
    private final List<Certificate> certificates;
    private final List<Link> links;

    public PersonDetail(FullName fullName, String city, String phoneNumber, String email, String summaryAboutMe, List<Skill> skills, List<Experience> experiences, List<Education> educations, List<Certificate> certificates, List<Link> links) {
        this.fullName = fullName;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.summaryAboutMe = summaryAboutMe;
        this.skills = skills;
        this.experiences = experiences;
        this.educations = educations;
        this.certificates = certificates;
        this.links = links;
    }

    public FullName getFullName() {
        return fullName;
    }

    public String getFirstName() {
        return fullName.getFirstName();
    }

    public String getLastName() {
        return fullName.getLastName();
    }

    public String getCity() {
        return city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getSummaryAboutMe() {
        return summaryAboutMe;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public List<Link> getLinks() {
        return links;
    }
}
