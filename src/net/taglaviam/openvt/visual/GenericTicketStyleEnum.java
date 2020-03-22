package net.taglaviam.openvt.visual;

public enum GenericTicketStyleEnum {

    MINUTA("Minuta"),
    JULIO("Julio"),
    OCTUBRE("Octubre");

    private String value;

    private GenericTicketStyleEnum(String value) {
        this.value = value;
    }

    @Override
    public final String toString() {
        return this.value;
    }

    public final static GenericTicketStyleEnum asEnum(String value) {
        return switch (value) {
            case "Julio": yield JULIO;
            case "Octubre": yield OCTUBRE;
            default: yield MINUTA;
        };
    }
}
