package commands;

import collection.CollectionManager;
import commands.manager.Command;
import console.ConsolePrinter;

public class GroupCountingByName extends Command {
    ConsolePrinter consolePrinter = new ConsolePrinter();
    CollectionManager collectionManager = new CollectionManager();
    @Override
    protected void execute(String[] commandName) {
        consolePrinter.print(collectionManager.group_counting_by_name().toString());
    }
}
