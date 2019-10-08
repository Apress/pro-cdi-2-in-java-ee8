package org.omnifaces.procdi.scopes.customscope;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.enterprise.context.NormalScope;

@NormalScope
@Retention(RUNTIME)
@Target({TYPE, FIELD, METHOD})
public @interface CustomScope {
}
