package net.taglaviam.openvt.visual;

public interface AbstractVisualCreator<E> {

    E create(final VisualProducer<E> visualProducer);

}
