package net.taglaviam.openvt.core.structural;

import java.util.Set;

public abstract class IspObject<Q,W,E> {

    protected Set<IspPropertie<Q,W,E>> ispProperties;

    protected Set<IspObject<Q,W,E>> ispObjects;

    protected Long tableLongHash;

    public abstract Set<IspPropertie<Q,W,E>> withIspProperties();

    public abstract Set<IspObject<Q,W,E>> withIspObjects();

    public abstract Long withTableLongHash();

    public abstract IspObject<Q,W,E> withIspProperties(final Set<IspPropertie<Q,W,E>> ispProperties);

    public abstract IspObject<Q,W,E> withIspPropertie(final IspPropertie<Q,W,E> ispPropertie);

    public abstract IspObject<Q,W,E> withIspObjects(Set<IspObject<Q,W,E>> ispObjects);

    public abstract IspObject<Q,W,E> withIspObject(IspObject<Q,W,E> ispObjects);

    public abstract IspObject<Q,W,E> withTableLongHash(final Long tableLongHash);
}