package net.taglaviam.openvt.core.structural;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class GenericIspObjectReader extends IspObjectReader {

    private final synchronized Boolean notEqualsToObjectHead(final String token) {
        return !(new ParenthesisIspSymbol().isTargetEqualToRepresentative(token));
    }

    private final synchronized Boolean notEqualsToObjectTail(final String token) {
        return !(new ParenthesisIspSymbol().isTargetEqualToDelimiter(token));
    }

    private final synchronized GenericIspPropertie mapToTupleAndGetPropertie(final String tuple) {
        final var objectStructure = Arrays.asList(tuple.split(":"));

        final var propertie = new GenericIspPropertie()
                .withKey(objectStructure.get(0))
                .withValue(objectStructure.get(1));

        return (GenericIspPropertie) propertie;
    }

    private final synchronized GenericIspObject mapToLineAndGetObject(final String line) {
        final var tokens = Arrays.asList(line.split("\\s+"));

        final var contentTokens = tokens.stream()
                .filter(this::notEqualsToObjectHead)
                .filter(this::notEqualsToObjectTail)
                .collect(Collectors.toList());

        final var tuples = IntStream.range(1, contentTokens.size())
                .filter(i -> i % 2 != 0)
                .mapToObj(i -> contentTokens.get(i-1) + ":" + contentTokens.get(i))
                .collect(Collectors.toList());

        final var object = new GenericIspObject().withIspProperties(tuples.stream()
                .map(this::mapToTupleAndGetPropertie)
                .collect(Collectors.toSet()))
                .withTableLongHash(System.nanoTime());

        return (GenericIspObject) object;
    }

    @Override
    public IspObjectReader withFileContentLines(File file) {
        try {
            this.fileContentLines = new BufferedReader(new FileReader(file)).lines().collect(Collectors.toList());
        } catch (final Exception ex) {
            this.fileContentLines = new ArrayList<>();
        }
        return this;
    }

    @Override
    public IspObjectReader withGenericIspObjects(Set<GenericIspObject> genericIspObjects) {
        this.genericIspObjects = genericIspObjects;
        return this;
    }

    @Override
    public Set<GenericIspObject> withGenericIspObjects() {
        return this.genericIspObjects;
    }

    @Override
    public IspObjectReader findGenericIspObjects() {
        this.genericIspObjects = this.fileContentLines.parallelStream()
                .map(this::mapToLineAndGetObject)
                .collect(Collectors.toSet());
        return this;
    }
}
