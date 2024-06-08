package org.example;

import java.util.*;

public class ClassInfo {
    private List<Method> methods = new ArrayList<>();
    private Set<String> attributes = new HashSet<>();
    public void addMethod(String methodName, Set<String> attrs) {
        Method method = new Method(methodName, attrs);
        methods.add(method);
        attributes.addAll(attrs);
    }
    public List<Method> getMethods() {
        return methods;
    }
    public Set<String> getAttributes() {
        return attributes;
    }
}
