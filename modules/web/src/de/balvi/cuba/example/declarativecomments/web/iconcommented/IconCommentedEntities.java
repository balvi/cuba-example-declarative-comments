package de.balvi.cuba.example.declarativecomments.web.iconcommented;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface IconCommentedEntities {
    String icon() default "font-icon:COMMENTING_O";
}