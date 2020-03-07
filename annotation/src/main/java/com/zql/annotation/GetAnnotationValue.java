package com.zql.annotation;

public class GetAnnotationValue {

    public static void getValue(Class<?> cls) {
        boolean annotationPresent = cls.isAnnotationPresent(TestAnnotation.class);
        if (annotationPresent) {
            TestAnnotation testAnnotation = cls.getAnnotation(TestAnnotation.class);
            System.out.println(testAnnotation.id());
            System.out.println(testAnnotation.msg());
        }
    }
}
