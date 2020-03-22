package net.taglaviam.openvt.core.structural;

public abstract class IspPropertie<Q,W,E> {

    protected Q key;
    protected W value;

    public abstract Q withKey();

    public abstract W withValue();

    public abstract E asLoggingResult();

    public abstract IspPropertie<Q,W,E> withKey(final Q key);

    public abstract IspPropertie<Q,W,E> withValue(final W value);
}
