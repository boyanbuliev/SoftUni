package gettersandsetters;

import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Reflection reflection = new Reflection();
        Class<Reflection> clazz = Reflection.class;
        Method[] methods = clazz.getDeclaredMethods();

        List<Method> getters = new ArrayList<>();
        List<Method> setters = new ArrayList<>();

        for (Method method : methods) {
            if (method.getName().startsWith("get")) {
                getters.add(method);
            } else if (method.getName().startsWith("set")) {
                setters.add(method);
            }
        }
        getters.sort(Comparator.comparing(Method::getName));
        setters.sort(Comparator.comparing(Method::getName));
        for (Method getter : getters) {
            System.out.printf("%s will return class %s%n", getter.getName(),
                    getter.getReturnType().getName());
        }
        for (Method setter : setters) {
            System.out.printf("%s and will set field of class %s%n", setter.getName(),
                    setter.getParameterTypes()[0].getName());
        }
    }
}
