package org.mapstruct.example.repo;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target( ElementType.TYPE )
@Retention( RetentionPolicy.CLASS )
public @interface AddToRepo {
}
