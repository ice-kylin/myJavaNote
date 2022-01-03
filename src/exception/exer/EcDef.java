package exception.exer;

public class EcDef extends RuntimeException {
    static final long serialVersionUID = -7034897123333766939L;

    public EcDef() {
    }

    public EcDef(String message) {
        super(message);
    }
}
