package de.balvi.cuba.example.declarativecomments.web.commentable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Commentable {
    String listComponent() default "";

    String buttonId() default "commentBtn";

    String buttonsPanel() default "buttonsPanel";
}