package org.example;

import java.util.*;

public class LCOM {
    public void calcLCOM(ClassInfo classInfo) {
        int p = 0, q = 0;
        List<Method> methods = classInfo.getMethods();
        for (int i = 0; i < methods.size(); i++) {
            for (int j = i + 1; j < methods.size(); j++) {
                Method method1 = methods.get(i);
                Method method2 = methods.get(j);
                Set<String> attrs1 = method1.getAttributes();
                Set<String> attrs2 = method2.getAttributes();
                Set<String> intersection = new HashSet<>(attrs1);
                intersection.retainAll(attrs2);
                if (intersection.isEmpty()) {
                    p++;
                } else {
                    q++;
                }
            }
        }
        int lcom = p - q;
        System.out.println("LCOM = " + lcom);
    }
    public static void main(String[] args) {
        ClassInfo classInfo = new ClassInfo();
        classInfo.addMethod("method1", new HashSet<>(Arrays.asList("attr1", "attr2")));
        classInfo.addMethod("method2", new HashSet<>(Arrays.asList("attr2")));
        classInfo.addMethod("method3", new HashSet<>(Arrays.asList("attr3")));
        LCOM lcom = new LCOM();
        lcom.calcLCOM(classInfo);
    }
}
