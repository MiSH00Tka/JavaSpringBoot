package org.example.homework3.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CustomValidator.class)
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomValidationAnnotation {

    String message() default "Строка должна начинаться с \"Custom\"";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
