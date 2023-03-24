package commands;

import commands.manager.Command;
import commands.manager.CommandManager;
import console.ConsolePrinter;

public class History extends Command {
    ConsolePrinter consolePrinter = new ConsolePrinter();
    @Override
    protected void execute(String[] commandName) {
        consolePrinter.print("Последние вызванные команды: ");
        try {
            for (int i = 0; i < 14; i++) {
                consolePrinter.print(CommandManager.getCommandHistory().get(i));
            }
        } catch (IndexOutOfBoundsException e) {
            consolePrinter.print("За время работы было вызвано менее 14 команд");
        }
    }
}
