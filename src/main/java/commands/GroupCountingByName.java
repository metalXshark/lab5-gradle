package commands;

import collection.CollectionManager;
import commands.manager.Command;
import console.ConsolePrinter;

public class GroupCountingByName extends Command {
    @Override
    protected void execute(String[] commandName) {
        consolePrinter.print(collectionManager.group_counting_by_name().toString());
    }
}
