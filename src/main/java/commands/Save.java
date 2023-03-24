package commands;

import collection.CollectionManager;
import commands.manager.Command;

public class Save extends Command {
    CollectionManager collectionManager = new CollectionManager();
    @Override
    protected void execute(String[] commandName) {
        collectionManager.save();
    }
}
