package net.taglaviam.openvt.core.structural;

public final class GenericIspPropertie extends IspPropertie<String, String, String> {

    @Override
    public String withKey() {
        return this.key;
    }

    @Override
    public String withValue() {
        return this.value;
    }

    @Override
    public String asLoggingResult() {
        return "key " + this.key + " value " + this.value;
    }

    @Override
    public IspPropertie<String, String, String> withKey(String key) {
        this.key = key;
        return this;
    }

    @Override
    public IspPropertie<String, String, String> withValue(String value) {
        this.value = value;
        return this;
    }
}
