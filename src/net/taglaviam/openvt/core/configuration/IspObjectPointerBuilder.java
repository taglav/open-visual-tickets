package net.taglaviam.openvt.core.configuration;

public interface IspObjectPointerBuilder<Q> {

    Q buildWith(final Q target, final Class<Q> clazz);

}
