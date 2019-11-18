package org.launchcode.inventorymvc.constraint;



import javax.validation.Payload;
import javax.validation.Constraint;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE,
        ANNOTATION_TYPE
})

@Retention(RUNTIME)
@Constraint(validatedBy = FieldMatchValidator.class)
@Documented

public @interface FieldMatch {

    String message() default "{constraints.field-match}";
    Class < ? >[] groups() default {};
    Class <? extends Payload>[] payload() default {};
    String first();
    String second();

    @Target({
            ElementType.TYPE,
            ElementType.ANNOTATION_TYPE })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        FieldMatch[] value();
    }

}
