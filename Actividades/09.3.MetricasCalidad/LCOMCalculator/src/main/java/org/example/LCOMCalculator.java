package org.example;
import java.util.*;

public class LCOMCalculator {
    private static class ClassInfo {
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
    private static class Method {
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
    public static void main(String[] args) {
        ClassInfo classInfo = new ClassInfo();
        // Simulación de entrada de métodos y sus accesos a atributos
        classInfo.addMethod("method1", new HashSet<>(Arrays.asList("attr1", "attr2")));
        classInfo.addMethod("method2", new HashSet<>(Arrays.asList("attr2")));
        classInfo.addMethod("method3", new HashSet<>(Arrays.asList("attr3")));
        calcLCOM(classInfo);
    }
    // Método para calcular LCOM
    public static void calcLCOM(ClassInfo classInfo) {
        int p = 0, q = 0;
        List<Method> methods = classInfo.getMethods();
        for (int i = 0; i < methods.size(); i++) {
            for (int j = i + 1; j < methods.size(); j++) {
                Method method1 = methods.get(i);
                Method method2 = methods.get(j);
                Set<String> attrs1 = method1.getAttributes();
                Set<String> attrs2 = method2.getAttributes();
                // Calculamos si comparten atributos
                Set<String> intersection = new HashSet<>(attrs1);
                intersection.retainAll(attrs2);
                if (intersection.isEmpty()) {
                    p++; // No comparten atributos
                } else {
                    q++; // Comparten al menos un atributo
                }
            }
        }
        int lcom = p - q;
        System.out.println("LCOM = " + lcom);
    }
}
