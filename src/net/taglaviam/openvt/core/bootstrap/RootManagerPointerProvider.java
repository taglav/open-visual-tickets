package net.taglaviam.openvt.core.bootstrap;

import net.taglaviam.openvt.core.configuration.GenericIspObjectPointerBuilder;
import net.taglaviam.openvt.core.configuration.IspObjectPointer;
import net.taglaviam.openvt.core.configuration.ObjectPointerSetupProvider;

@IspObjectPointer(file = "/usr/local/share/src/america/open-visual-tickets/tmp/rootmanager.ovts")
public final class RootManagerPointerProvider implements ObjectPointerSetupProvider<RootManagerPointerProvider> {

    private String prefixPath;
    private String acceptableExtension;
    private String fileNameMaxLen;
    private String maxTickets;

    @Override
    public RootManagerPointerProvider setup() {
        return new GenericIspObjectPointerBuilder<RootManagerPointerProvider>().buildWith(
                this, RootManagerPointerProvider.class);
    }

    public String withPrefixPath() {
        return prefixPath;
    }

    public String withAcceptableExtension() {
        return acceptableExtension;
    }

    public String withFileNameMaxLen() {
        return fileNameMaxLen;
    }

    public String withMaxTickets() {
        return maxTickets;
    }
}
