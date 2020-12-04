package blackBoxInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Constructor<BlackBoxInt> constructor = BlackBoxInt.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();
        Field innerValue = blackBoxInt.getClass().getDeclaredField("innerValue");
        innerValue.setAccessible(true);
        String input;
        while (!"END".equals(input = br.readLine())) {
            String[] tokens = input.split("_");
            switch (tokens[0]) {
                case "add":
                    Method add = blackBoxInt.getClass().getDeclaredMethod("add", int.class);
                    add.setAccessible(true);
                    add.invoke(blackBoxInt, Integer.parseInt(tokens[1]));
                    System.out.println(innerValue.get(blackBoxInt));
                    break;
                case "subtract":
                    Method subtract = blackBoxInt.getClass().getDeclaredMethod("subtract", int.class);
                    subtract.setAccessible(true);
                    subtract.invoke(blackBoxInt, Integer.parseInt(tokens[1]));
                    System.out.println(innerValue.get(blackBoxInt));
                    break;
                case "multiply":
                    Method multiply = blackBoxInt.getClass().getDeclaredMethod("multiply", int.class);
                    multiply.setAccessible(true);
                    multiply.invoke(blackBoxInt, Integer.parseInt(tokens[1]));
                    System.out.println(innerValue.get(blackBoxInt));
                    break;
                case "divide":
                    Method divide = blackBoxInt.getClass().getDeclaredMethod("divide", int.class);
                    divide.setAccessible(true);
                    divide.invoke(blackBoxInt, Integer.parseInt(tokens[1]));
                    System.out.println(innerValue.get(blackBoxInt));
                    break;
                case "leftShift":
                    Method leftShift = blackBoxInt.getClass().getDeclaredMethod("leftShift", int.class);
                    leftShift.setAccessible(true);
                    leftShift.invoke(blackBoxInt, Integer.parseInt(tokens[1]));
                    System.out.println(innerValue.get(blackBoxInt));
                    break;
                case "rightShift":
                    Method rightShift = blackBoxInt.getClass().getDeclaredMethod("rightShift", int.class);
                    rightShift.setAccessible(true);
                    rightShift.invoke(blackBoxInt, Integer.parseInt(tokens[1]));
                    System.out.println(innerValue.get(blackBoxInt));
                    break;
            }
        }
    }
}
