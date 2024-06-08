package org.example;

import java.util.*;

public class Method {
    private String name;
    private Set<String> attributes;

    public Method(String name, Set<String> attributes) {
        if (name == null) {
            throw new NullPointerException("El nombre no puede ser nulo");
        }
        if (attributes == null) {
            throw new NullPointerException("Los atributos no pueden ser nulos");
        }
        this.name = name;
        this.attributes = attributes;
    }
    public String getName() {
        return name;
    }
    public Set<String> getAttributes() {
        return attributes;
    }
}
