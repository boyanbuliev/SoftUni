package barracksWars.core;

import barracksWars.core.commands.AddCommand;
import barracksWars.core.commands.Command;
import barracksWars.core.commands.ReportCommand;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Runnable;
import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Engine implements Runnable {

    private Repository repository;
    private UnitFactory unitFactory;

    public Engine(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            try {
                String input = reader.readLine();
                String[] data = input.split("\\s+");
                String commandName = data[0];
                String result = interpretCommand(data, commandName);
                if (result.equals("fight")) {
                    break;
                }
                System.out.println(result);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // TODO: refactor for problem 4
    private String interpretCommand(String[] data, String commandName) {
        String result = "";
        commandName = "barracksWars.core.commands." +
                commandName.substring(0, 1).toUpperCase() + commandName.substring(1) + "Command";
        try {
            Object o = Class.forName(commandName).getDeclaredConstructor(String[].class,
                    Repository.class, UnitFactory.class)
                    .newInstance(data, repository, unitFactory);
            result= ((Command)o).execute();
//

        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException
                | InvocationTargetException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}
