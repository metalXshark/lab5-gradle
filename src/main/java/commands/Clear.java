package commands;

import collection.CollectionManager;
import commands.manager.Command;

import java.io.ObjectInputStream;

public class Clear extends Command {
    @Override
    protected void execute(String[] commandName) {
        collectionManager.clear();
        successResult();
    }
}
