package net.taglaviam.openvt.core.structural;

public abstract class IspSymbol<W> implements SymbolChecker<W> {

    protected W representative;
    protected W delimiter;

    abstract W withRepresentative();
    abstract W withDelimiter();
}
