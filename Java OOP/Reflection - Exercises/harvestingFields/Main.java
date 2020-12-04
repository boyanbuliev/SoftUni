package harvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Class<RichSoilLand> richSoilLandClass = RichSoilLand.class;
        Field[] fields = richSoilLandClass.getDeclaredFields();

        String input;
        while (!"HARVEST".equals(input = br.readLine())) {
            printField(fields, input);


        }

    }

    private static void printField(Field[] fields, String input) {
        switch (input) {
            case "private":
                for (Field field : fields) {
                    if (Modifier.isPrivate(field.getModifiers())) {
                        System.out.printf("%s %s %s%n", Modifier.toString(field.getModifiers()),
                                field.getType().getSimpleName(), field.getName());
                    }
                }
                break;
            case "protected":
                for (Field field : fields) {
                    if (Modifier.isProtected(field.getModifiers())) {
                        System.out.printf("%s %s %s%n", Modifier.toString(field.getModifiers()),
                                field.getType().getSimpleName(), field.getName());
                    }
                }
                break;
            case "public":
                for (Field field : fields) {
                    if (Modifier.isPublic(field.getModifiers())) {
                        System.out.printf("%s %s %s%n", Modifier.toString(field.getModifiers()),
                                field.getType().getSimpleName(), field.getName());
                    }
                }
                break;
            case "all":
                for (Field field : fields) {
                    System.out.printf("%s %s %s%n", Modifier.toString(field.getModifiers()),
                            field.getType().getSimpleName(), field.getName());
                }
                break;
        }
    }
}
