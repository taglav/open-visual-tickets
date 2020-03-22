package net.taglaviam.openvt.core.bootstrap;

import net.taglaviam.openvt.core.configuration.ObjectPointerSetupProvider;

import java.io.File;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public final class TicketManagerSetProvider implements ObjectPointerSetupProvider<Set<TicketManagerPointerProvider>> {

    private final String mapFileToStringName(final File file) {
        return file.getAbsolutePath();
    }

    private final synchronized TicketManagerPointerProvider mapFileNameToGlobalTicketProvider(final String fileName) {
        return new TicketManagerPointerProvider().fullFillFilePath(fileName).setup();
    }

    @Override
    public Set<TicketManagerPointerProvider> setup() {

        final var rootManagerConfigProvider = new RootManagerPointerProvider().setup();

        final var allowedFiles = Arrays.stream(new File(rootManagerConfigProvider.withPrefixPath()).listFiles(
                (d, n) -> n.trim().endsWith(rootManagerConfigProvider.withAcceptableExtension())))
                .map(this::mapFileToStringName)
                .sorted()
                .collect(Collectors.toList());

        final var ticketManagerSet = allowedFiles.parallelStream()
                .map(this::mapFileNameToGlobalTicketProvider)
                .collect(Collectors.toSet());

        return ticketManagerSet;
    }

}
