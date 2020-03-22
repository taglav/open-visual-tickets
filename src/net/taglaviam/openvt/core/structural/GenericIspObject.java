package net.taglaviam.openvt.core.structural;

import java.util.Set;

public final class GenericIspObject extends IspObject<String, String, String> {

    @Override
    public Set<IspPropertie<String, String, String>> withIspProperties() {
        return this.ispProperties;
    }

    @Override
    public Set<IspObject<String, String, String>> withIspObjects() {
        return this.ispObjects;
    }

    @Override
    public Long withTableLongHash() {
        return this.tableLongHash;
    }

    @Override
    public IspObject<String, String, String> withIspProperties(final Set<IspPropertie<String, String, String>> ispProperties) {
        this.ispProperties = ispProperties;
        return this;
    }

    @Override
    public IspObject<String, String, String> withIspPropertie(final IspPropertie<String, String, String> ispPropertie) {
        if(this.ispProperties != null)
            this.ispProperties.add(ispPropertie);

        return this;
    }

    @Override
    public IspObject<String, String, String> withIspObjects(final Set<IspObject<String, String, String>> ispObjects) {
        this.ispObjects = ispObjects;
        return this;
    }

    @Override
    public IspObject<String, String, String> withIspObject(final IspObject<String, String, String> ispObject) {
        if(this.ispObjects != null)
            this.ispObjects.add(ispObject);

        return this;
    }

    @Override
    public IspObject<String, String, String> withTableLongHash(final Long tableLongHash){
        this.tableLongHash = tableLongHash;
        return this;
    }
}
