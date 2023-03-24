package commands;

import commands.manager.Command;
import commands.manager.CommandManager;
import console.ConsolePrinter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExecuteScript extends Command {
    CommandManager commandManager = new CommandManager();
    ConsolePrinter consolePrinter = new ConsolePrinter();
    @Override
    protected void execute(String[] commandName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(commandName[1]))) {
            String line;
            while ((line = reader.readLine()) != null) {
                consolePrinter.print("===============================================================\n" + line);
                commandManager.executeCommand(line.split(" "));
            }
        } catch (IOException e) {
            consolePrinter.print(e.getMessage());
        } catch (SecurityException e) {
            consolePrinter.print("Недостаточно прав для открытия файла.");
        } catch (NullPointerException e) {
            consolePrinter.print("Файл пуст");
        }
    }
}
