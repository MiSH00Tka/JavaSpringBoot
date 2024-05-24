package org.example.homework3.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Size;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@CustomValidationAnnotation
@Size(max = 30)
public @interface CombinedValidation {

    String message() default "Строка должна начинаться с \"Custom\" и содержать не более 30 символов";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
