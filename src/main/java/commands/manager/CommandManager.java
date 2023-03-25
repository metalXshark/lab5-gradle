package commands.manager;

import java.util.ArrayList;
import java.util.HashMap;

public class CommandManager {
    private static final HashMap<String, Command> commandMap = new HashMap<>();
    private static final ArrayList<String> commandHistory = new ArrayList<>();

    public void command(String name, Command command) {
        commandMap.put(name, command);
    }
    public void executeCommand(String[] commandName) {
        try {
            commandHistory.add(commandName[0]);
            Command command = commandMap.get(commandName[0]);
            switch (commandName[0]){
                case "update", "remove_by_id", "execute_script":
                    if (commandName.length < 3) {
                        command.execute(commandName);
                    } else {
                        System.out.println("Некорректное количество аргументов. Для справки напишите help.");
                    }
                    break;
                default:
                    if (commandName.length < 2) {
                        command.execute(commandName);
                    } else {
                        System.out.println("Некорректное количество аргументов. Для справки напишите help.");
                    }
            }
        } catch (IllegalStateException | NullPointerException ex) {
            System.out.println("Не существует команды \"" + commandName[0] + "\"\nДля справки используйте - help");
        }
    }
    public static ArrayList<String> getCommandHistory(){
        return commandHistory;
    }
}
