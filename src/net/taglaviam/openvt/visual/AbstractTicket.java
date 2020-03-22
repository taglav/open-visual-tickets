package net.taglaviam.openvt.visual;

import net.taglaviam.openvt.core.bootstrap.TicketManagerPointerProvider;

import javax.swing.*;

public abstract class AbstractTicket extends JFrame {

    private AbstractTicket() {
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setAlwaysOnTop(true);
        this.setAutoRequestFocus(true);
        this.setUndecorated(true);
        this.setLayout(null);
        this.setResizable(false);
        this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
    }

    public AbstractTicket(final TicketManagerPointerProvider ticketManagerPointerProvider) {
        this();

        this.setName(
                ticketManagerPointerProvider.withTicketName());

        this.setTitle(
                ticketManagerPointerProvider.withTicketName());

        this.setSize(
                Integer.parseInt(ticketManagerPointerProvider.withTicketWidth()),
                Integer.parseInt(ticketManagerPointerProvider.withTicketHeight()));

        this.setContentPane(
                new GenericTicketContentCreator().create(() ->
                        new GenericTicketContent().withCustomStyle(ticketManagerPointerProvider)));

        this.setLocation(
                new GenericTicketPositionPointCreator().create(() ->
                        new GenericTicketPositionPoint().withCustomLocal(ticketManagerPointerProvider)));
    }

}
