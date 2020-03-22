package net.taglaviam.openvt.visual;

import net.taglaviam.openvt.core.bootstrap.TicketManagerPointerProvider;

import java.awt.*;

public final class GenericTicketPositionPoint extends Point {

    public GenericTicketPositionPoint(Short x, Short y) {
        super(x, y);
    }

    public GenericTicketPositionPoint() {
        super(0,0);
    }

    public final GenericTicketPositionPoint withCustomLocal(final TicketManagerPointerProvider ticketManagerPointerProvider) {

        final var toolkit = Toolkit.getDefaultToolkit();
        final var ticketWidth = Integer.parseInt(ticketManagerPointerProvider.withTicketWidth());
        final var ticketHeight = Integer.parseInt(ticketManagerPointerProvider.withTicketHeight());
        final var ticketLocal = Integer.parseInt(ticketManagerPointerProvider.withTicketLocal());
        final var localization = ticketLocal <= 0 ? 1 : ticketLocal;

        final var defaultLowerAxis = toolkit.getScreenSize().getHeight() - (ticketHeight + 2);

        final var defaultAccessibleAxis = ((toolkit.getScreenSize().getWidth() / ticketWidth) +
                (ticketWidth + 2)) * localization;

        this.setLocation(defaultAccessibleAxis, defaultLowerAxis);

        return this;
    }

}
