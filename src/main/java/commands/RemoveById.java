package commands;

import collection.CollectionManager;
import commands.manager.Command;

public class RemoveById extends Command {
    CollectionManager collectionManager = new CollectionManager();

    @Override
    protected void execute(String[] commandName) {
        collectionManager.remove_by_id(commandName[1]);
    }
}
