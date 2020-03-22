package net.taglaviam.openvt.core.configuration;

import net.taglaviam.openvt.core.structural.GenericIspObject;
import net.taglaviam.openvt.core.structural.GenericIspObjectReader;
import net.taglaviam.openvt.core.structural.GenericIspPropertie;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Set;

public final class GenericIspObjectPointerBuilder<Q> implements IspObjectPointerBuilder<Q> {

    private final Field mapFieldToAccessible(final Field field) {
        field.setAccessible(true);
        return field;
    }

    private final Field mergeFieldByPropertie(
            final Q target,
            final Field field,
            final GenericIspPropertie genericIspPropertie) {

        try {
            if (field.getName().equalsIgnoreCase(genericIspPropertie.withKey()))
                field.set(target, genericIspPropertie.withValue());
        } catch (final Exception ex) {
            ex.printStackTrace();
        }

        return field;
    }

    private final Field mergeFieldOnObjectTable(
            final Q target,
            final Field field,
            final Set<GenericIspObject> genericIspObjects) {

        if(genericIspObjects != null && !genericIspObjects.isEmpty())
            genericIspObjects.stream()
                    .map(o -> o.withIspProperties())
                    .flatMap(Set::stream)
                    .forEach(p -> mergeFieldByPropertie(target, field, (GenericIspPropertie) p));

        return field;
    }

    private final Q mergeWithParityIspObjectsAndGet(
            final Q target,
            final Class<Q> clazz,
            final Set<GenericIspObject> genericIspObjects) {

        Arrays.asList(clazz.getDeclaredFields()).stream()
                .map(this::mapFieldToAccessible)
                .forEach(f ->  mergeFieldOnObjectTable(target, f, genericIspObjects));

        return target;
    }

    @Override
    public Q buildWith(final Q target, final Class<Q> clazz) {

        final var objPointerAnnotation = clazz.getAnnotation(IspObjectPointer.class);

        final var hasObjPointerAnnotation = objPointerAnnotation != null &&
                !(objPointerAnnotation.file().isEmpty());

        final var validFile = hasObjPointerAnnotation
                ? new File(objPointerAnnotation.file())
                : null;

        final var extractedObjects = validFile != null
                ? new GenericIspObjectReader()
                    .withFileContentLines(validFile)
                    .findGenericIspObjects()
                    .withGenericIspObjects()
                : null;

        return mergeWithParityIspObjectsAndGet(target, clazz, extractedObjects);
    }
}
