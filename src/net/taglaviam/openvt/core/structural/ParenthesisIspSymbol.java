package net.taglaviam.openvt.core.structural;

public final class ParenthesisIspSymbol extends IspSymbol<String> {

    public ParenthesisIspSymbol() {
        this.representative = "(";
        this.delimiter = ")";
    }

    @Override
    String withRepresentative() {
        return this.representative;
    }

    @Override
    String withDelimiter() {
        return this.delimiter;
    }

    @Override
    public Boolean isTargetEqualToRepresentative(final String target) {
        return target != null && this.representative.trim().equalsIgnoreCase(target.trim());
    }

    @Override
    public Boolean isTargetEqualToDelimiter(final String target) {
        return target != null && this.delimiter.trim().equalsIgnoreCase(target.trim());
    }
}
