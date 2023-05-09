package com.andresmromero.br.bo.context.shared.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface ApplicationSvc {

    @AliasFor(annotation = Component.class) String value() default "";

}
