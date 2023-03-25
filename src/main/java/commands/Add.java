package commands;

import collection.CollectionManager;
import commands.manager.Command;
import commands.manager.CreateObject;

public class Add extends Command {
    @Override
    protected void execute(String[] commandName) {
        collectionManager.add(CreateObject.createDragon());
        successResult();
    }
}
