package net.taglaviam.openvt.visual;

import net.taglaviam.openvt.core.bootstrap.TicketManagerPointerProvider;

import javax.swing.*;
import java.awt.*;

public final class GenericTicketContent extends JPanel {

    public GenericTicketContent() {
        super();
        this.setLayout(null);
    }

    private final GenericTicketContent withDefaultBackgroundColor(final Color color) {
        this.setBackground(color);
        return this;
    }

    public final GenericTicketContent withCustomStyle(final TicketManagerPointerProvider ticketManagerPointerProvider) {
        return switch (GenericTicketStyleEnum.asEnum(ticketManagerPointerProvider.withTicketStyle())) {
            case JULIO: yield withDefaultBackgroundColor(Color.YELLOW);
            case OCTUBRE: yield withDefaultBackgroundColor(Color.ORANGE);
            case MINUTA: yield withDefaultBackgroundColor(Color.BLACK);
        };
    }

}
