package net.taglaviam.openvt.core.configuration;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface IspObjectPointer {
    String file() default "";
}
