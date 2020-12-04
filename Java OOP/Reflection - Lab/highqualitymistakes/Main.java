package highqualitymistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Class<Reflection> clazz = Reflection.class;

        Field[] fields = Arrays.stream(clazz.getDeclaredFields()).sorted(Comparator.comparing(Field::getName))
                .toArray(Field[]::new);
        List<Method> getters = Arrays.stream(clazz.getDeclaredMethods()).filter(e -> e.getName()
                .startsWith("get")).sorted(Comparator.comparing(Method::getName)).collect(Collectors.toList());
        List<Method> setters = Arrays.stream(clazz.getDeclaredMethods()).filter(e -> e.getName()
                .startsWith("set")).sorted(Comparator.comparing(Method::getName)).collect(Collectors.toList());

        for (Field field : fields) {
            if (!Modifier.isPrivate(field.getModifiers())) {
                System.out.println(field.getName() + " must be private!");
            }
        }
        for (Method getter : getters) {
            if (!Modifier.isPublic(getter.getModifiers())) {
                System.out.println(getter.getName() + " have to be public!");
            }
        }
        for (Method setter : setters) {
            if (!Modifier.isPrivate(setter.getModifiers())) {
                System.out.println(setter.getName() + " have to be private!");
            }
        }

    }
}

