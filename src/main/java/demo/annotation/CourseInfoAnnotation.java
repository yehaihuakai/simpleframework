package demo.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface CourseInfoAnnotation {
    public String courseName();

    public String courseTag();

    public String courseProfile();

    public int courseIndex() default 303;
}
