package org.mym.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationSettings {
    private final AnnotationConfigApplicationContext context;

    public ApplicationSettings(Class clazz) {
        this.context = new AnnotationConfigApplicationContext(clazz);
    }

    public AnnotationConfigApplicationContext getContext() {
        return context;
    }
}
