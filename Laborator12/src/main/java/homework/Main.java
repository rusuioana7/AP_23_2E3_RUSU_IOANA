package homework;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Main {
    public static void main(String[] args) throws Exception {
//        String path = "target/classes/homework";
        String path = "src/main/java/javax.servlet-api-4.0.1.jar";
        List<Class<?>> testClasses = new ArrayList<>();
        ClassLoader classLoader = Main.class.getClassLoader();
        exploreFolder(new File(path), testClasses, classLoader);

        int testMethodsCount = 0;
        int regularMethodsCount = 0;

        for (Class<?> testClass : testClasses) {
            System.out.println("Class: " + testClass.getName());
            System.out.println("Package: " + testClass.getPackage().getName());

            Method[] methods = testClass.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Test.class) && Modifier.isStatic(method.getModifiers())) {
                    System.out.println("Test method: " + method.getName());
                    testMethodsCount++;
                } else {
                    System.out.println("Method: " + method.getName());
                    regularMethodsCount++;
                }
            }
        }

        System.out.println("Test methods count: " + testMethodsCount);
        System.out.println("Regular methods count: " + regularMethodsCount);
    }

    private static void exploreFolder(File file, List<Class<?>> testClasses, ClassLoader classLoader) throws IOException {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File subFile : files) {
                    exploreFolder(subFile, testClasses, classLoader);
                }
            }
        } else if (file.isFile() && file.getName().endsWith(".class")) {
            String className = getClassNameFromFile(file, file.getAbsolutePath());
            if (className != null) {
                try {
                    Class<?> clazz = classLoader.loadClass(className);
                    testClasses.add(clazz);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } else if (file.isFile() && file.getName().endsWith(".jar")) {
            exploreJar(file, testClasses, classLoader);
        }
    }

    private static void exploreJar(File file, List<Class<?>> testClasses, ClassLoader classLoader) throws IOException {
        try (JarFile jarFile = new JarFile(file)) {
            URL[] urls = {new URL("jar:file:" + file.getAbsolutePath() + "!/")};
            try (URLClassLoader jarClassLoader = URLClassLoader.newInstance(urls, classLoader)) {
                Enumeration<JarEntry> entries = jarFile.entries();
                while (entries.hasMoreElements()) {
                    JarEntry jarEntry = entries.nextElement();
                    if (jarEntry.isDirectory() || !jarEntry.getName().endsWith(".class")) {
                        continue;
                    }
                    String className = jarEntry.getName().substring(0, jarEntry.getName().length() - 6)
                            .replace('/', '.');
                    try {
                        Class<?> clazz = jarClassLoader.loadClass(className);
                        testClasses.add(clazz);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static String getClassNameFromFile(File file, String absolutePath) {
        String filePath = absolutePath;
        String className = null;
        if (filePath.contains("classes")) {
            String prefix = "classes" + File.separator;
            int startIndex = filePath.indexOf(prefix);
            if (startIndex != -1) {
                int endIndex = filePath.lastIndexOf(".class");
                if (endIndex != -1) {
                    className = filePath.substring(startIndex + prefix.length(), endIndex).replace(File.separator, ".");
                }
            }
        }
        return className;
    }


}
