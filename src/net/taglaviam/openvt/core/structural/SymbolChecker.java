package net.taglaviam.openvt.core.structural;

public interface SymbolChecker<W> {

    Boolean isTargetEqualToRepresentative(final W target);

    Boolean isTargetEqualToDelimiter(final W target);

}
