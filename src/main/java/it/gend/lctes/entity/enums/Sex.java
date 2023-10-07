package it.gend.lctes.entity.enums;

public enum Sex {
    M("Male"),
    F("Female");
    String label;
    Sex(String label) {
        this.label = label;
    }
    public String getLabel() {
        return label;
    }
}
