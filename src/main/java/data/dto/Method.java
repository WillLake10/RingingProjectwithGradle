package data.dto;

public class Method {
    private String ID;
    private String name;
    private String title;
    private String notation;
    private int stage;
    private String classification;
    private int lengthOfLead;
    private int numberOfHunts;
    private String leadHead;
    private String leadHeadCode;
    private String symmetry;
    private String notes;

    public Method() {
        this.classification = "";
        this.stage = 0;
        this.lengthOfLead = 0;
        this.numberOfHunts = 0;
        this.leadHead = "";
        this.leadHeadCode = "";
        this.symmetry = "";
        this.name = "";
        this.title = "";
        this.notation = "";
        this.ID = "";
        this.notes = "";
    }

    public Method(String classification, int stage, int lengthOfLead, int numberOfHunts, String leadHead, String leadHeadCode, String symmetry, String name, String title, String notation, String ID, String notes) {
        this.classification = classification;
        this.stage = stage;
        this.lengthOfLead = lengthOfLead;
        this.numberOfHunts = numberOfHunts;
        this.leadHead = leadHead;
        this.leadHeadCode = leadHeadCode;
        this.symmetry = symmetry;
        this.name = name;
        this.title = title;
        this.notation = notation;
        this.ID = ID;
        this.notes = notes;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotation() {
        return notation;
    }

    public void setNotation(String notation) {
        this.notation = notation;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Method{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", notation='" + notation + '\'' +
                ", stage=" + stage +
                ", classification='" + classification + '\'' +
                ", lengthOfLead=" + lengthOfLead +
                ", numberOfHunts=" + numberOfHunts +
                ", leadHead='" + leadHead + '\'' +
                ", leadHeadCode='" + leadHeadCode + '\'' +
                ", symmetry='" + symmetry + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
