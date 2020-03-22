package net.taglaviam.openvt.visual;

public final class GenericTicketPositionPointCreator implements AbstractVisualCreator<GenericTicketPositionPoint> {

    @Override
    public GenericTicketPositionPoint create(VisualProducer<GenericTicketPositionPoint> visualProducer) {
        return visualProducer.produce();
    }

}
