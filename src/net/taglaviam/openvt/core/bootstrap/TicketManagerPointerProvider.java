package net.taglaviam.openvt.core.bootstrap;

import net.taglaviam.openvt.core.configuration.GenericIspObjectPointerBuilder;
import net.taglaviam.openvt.core.configuration.IspObjectPointer;
import net.taglaviam.openvt.core.configuration.ObjectPointerSetupProvider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

@IspObjectPointer
public final class TicketManagerPointerProvider implements ObjectPointerSetupProvider<TicketManagerPointerProvider> {

    private String ticketName;
    private String ticketWidth;
    private String ticketHeight;
    private String ticketStyle;
    private String ticketIcon;
    private String ticketEvent;
    private String ticketLocal;

    private final Field getAccessibleField(final Field field) {
        field.setAccessible(true);
        return field;
    }

    private final Method getAccessibleMethod(final Method method) {
        method.setAccessible(true);
        return method;
    }

    private final TicketManagerPointerProvider withUpdatedFields(
            final Map<Class<? extends Annotation>, Annotation> annotationsMap,
            final IspObjectPointer ispObjectPointer) {
        annotationsMap.put(IspObjectPointer.class, ispObjectPointer);
        return this;
    }

    public final TicketManagerPointerProvider fullFillFilePath(final String filePath) {
        try {
            final var objPointerAnnotation = this.getClass().getAnnotation(IspObjectPointer.class);

            final var newPointerAnnotation = new IspObjectPointer() {
                @Override
                public Class<? extends Annotation> annotationType() {
                    return objPointerAnnotation.annotationType();
                }

                @Override
                public String file() {
                    return filePath;
                }
            };

            final var method = getAccessibleMethod(
                    Class.class.getDeclaredMethod("annotationData", null));

            final var annotationData = method.invoke(
                    TicketManagerPointerProvider.class);

            final var annotations = getAccessibleField(
                    annotationData.getClass().getDeclaredField("annotations"));

            final var annotationsMap = (Map<Class<? extends Annotation>, Annotation>) annotations.get(annotationData);

            return withUpdatedFields(annotationsMap, newPointerAnnotation);

        } catch (Exception ex) {
            ex.printStackTrace();
            return this;
        }
    }

    @Override
    public TicketManagerPointerProvider setup() {
        return new GenericIspObjectPointerBuilder<TicketManagerPointerProvider>().buildWith(
                this, TicketManagerPointerProvider.class);
    }

    public String withTicketName() {
        return ticketName;
    }

    public String withTicketWidth() {
        return ticketWidth;
    }

    public String withTicketHeight() {
        return ticketHeight;
    }

    public String withTicketStyle() {
        return ticketStyle;
    }

    public String withTicketIcon() {
        return ticketIcon;
    }

    public String withTicketEvent() {
        return ticketEvent;
    }

    public String withTicketLocal() {
        return ticketLocal;
    }
}
