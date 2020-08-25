package data.xmlParser.dto;


public class PropertiesDto {
    private String classification;
    private int stage;
    private int lengthOfLead;
    private int numberOfHunts;
    private String leadHead;
    private String leadHeadCode;
    private String symmetry;

    public PropertiesDto() {
        this.classification = "";
        this.stage = 0;
        this.lengthOfLead = 0;
        this.numberOfHunts = 0;
        this.leadHead = "";
        this.leadHeadCode = "";
        this.symmetry = "";
    }

    public PropertiesDto(String classification,
                         int stage,
                         int lengthOfLead,
                         int numberOfHunts,
                         String leadHead,
                         String leadHeadCode,
                         String symmetry) {
        this.classification = classification;
        this.stage = stage;
        this.lengthOfLead = lengthOfLead;
        this.numberOfHunts = numberOfHunts;
        this.leadHead = leadHead;
        this.leadHeadCode = leadHeadCode;
        this.symmetry = symmetry;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public int getLengthOfLead() {
        return lengthOfLead;
    }

    public void setLengthOfLead(int lengthOfLead) {
        this.lengthOfLead = lengthOfLead;
    }

    public int getNumberOfHunts() {
        return numberOfHunts;
    }

    public void setNumberOfHunts(int numberOfHunts) {
        this.numberOfHunts = numberOfHunts;
    }

    public String getLeadHead() {
        return leadHead;
    }

    public void setLeadHead(String leadHead) {
        this.leadHead = leadHead;
    }

    public String getLeadHeadCode() {
        return leadHeadCode;
    }

    public void setLeadHeadCode(String leadHeadCode) {
        this.leadHeadCode = leadHeadCode;
    }

    public String getSymmetry() {
        return symmetry;
    }

    public void setSymmetry(String symmetry) {
        this.symmetry = symmetry;
    }

    @Override
    public String toString() {
        return "PropertiesDto{" +
                "classification='" + classification + '\'' +
                ", stage=" + stage +
                ", lengthOfLead=" + lengthOfLead +
                ", numberOfHunts=" + numberOfHunts +
                ", leadHead='" + leadHead + '\'' +
                ", leadHeadCode='" + leadHeadCode + '\'' +
                ", symmetry='" + symmetry + '\'' +
                '}';
    }
}
