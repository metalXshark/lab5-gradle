package commands;

import commands.manager.Command;
import commands.manager.CommandManager;
import console.ConsolePrinter;

public class History extends Command {
    @Override
    protected void execute(String[] commandName) {
        consolePrinter.print("Последние вызванные команды: ");
        try {
            for (int i = 0; i < 14; i++) {
                consolePrinter.print(CommandManager.getCommandHistory().get(i));
            }
            successResult();
        } catch (Exception e) {
            errorResult(commandName[0], e);
        }
    }
}
