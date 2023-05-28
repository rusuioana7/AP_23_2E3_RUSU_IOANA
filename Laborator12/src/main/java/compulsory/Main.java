package compulsory;

import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


public class Main {
    public static void main(String[] args) throws Exception {
        String className = "compulsory.RandomTest";

        Class<?> testClass = Class.forName(className);

        System.out.println("Class: " + testClass.getName());
        System.out.println("Package: " + testClass.getPackage().getName());

        Method[] methods = testClass.getDeclaredMethods();
        // Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println("Method: " + method.getName());
        }

        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class) && Modifier.isStatic(method.getModifiers())) {
                System.out.println("Test method: " + method.getName());
                method.invoke(null);
            }
        }
    }
}