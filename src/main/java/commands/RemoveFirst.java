package commands;

import collection.CollectionManager;
import commands.manager.Command;

public class RemoveFirst extends Command {
    CollectionManager collectionManager = new CollectionManager();
    @Override
    protected void execute(String[] commandName) {
        collectionManager.remove_first();
    }
}
