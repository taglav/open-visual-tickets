package net.taglaviam.openvt.visual;

import net.taglaviam.openvt.core.bootstrap.TicketManagerPointerProvider;

public final class GenericTicketContentCreator implements AbstractVisualCreator<GenericTicketContent> {

    @Override
    public GenericTicketContent create(VisualProducer<GenericTicketContent> visualProducer) {
        return visualProducer.produce();
    }

}
