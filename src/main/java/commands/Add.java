package commands;

import collection.CollectionManager;
import commands.manager.Command;
import commands.manager.CreateObject;

public class Add extends Command {
    CollectionManager collectionManager = new CollectionManager();
    @Override
    protected void execute(String[] commandName) {
        collectionManager.add(CreateObject.createDragon());
    }
}
