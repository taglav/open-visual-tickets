package net.taglaviam.openvt.visual;

public final class GenericTicketCreator implements AbstractVisualCreator<GenericTicket> {

    @Override
    public GenericTicket create(VisualProducer<GenericTicket> visualProducer) {
        return visualProducer.produce();
    }

}
