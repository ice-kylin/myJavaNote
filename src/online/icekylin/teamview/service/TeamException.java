package online.icekylin.teamview.service;

public class TeamException extends RuntimeException {
    static final long serialVersionUID = -7032337190745766939L;

    public TeamException() {
    }

    public TeamException(String message) {
        super(message);
    }
}
