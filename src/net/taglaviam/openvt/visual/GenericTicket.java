package net.taglaviam.openvt.visual;

import net.taglaviam.openvt.core.bootstrap.TicketManagerPointerProvider;

public final class GenericTicket extends AbstractTicket {

    public GenericTicket(TicketManagerPointerProvider ticketManagerPointerProvider) {
        super(ticketManagerPointerProvider);
        this.repaint();
        this.setVisible(true);
    }

}
