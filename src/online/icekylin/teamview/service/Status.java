package online.icekylin.teamview.service;

public class Status {
    private final String NAME;
    private static final Status FREE = new Status("FREE");
    private static final Status BUSY = new Status("BUSY");
    private static final Status VOCATION = new Status("VOCATION");

    private Status(String name) {
        this.NAME = name;
    }

    public String getNAME() {
        return NAME;
    }
}
