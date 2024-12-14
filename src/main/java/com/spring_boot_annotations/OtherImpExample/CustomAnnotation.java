package com.spring_boot_annotations.OtherImpExample;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)  // Specifies that this annotation can only be used on methods.
@Retention(RetentionPolicy.RUNTIME)  // Keeps the annotation available at runtime.
public @interface CustomAnnotation {
    String description() default "Custom annotation example";  // Custom attribute with default value.
}
