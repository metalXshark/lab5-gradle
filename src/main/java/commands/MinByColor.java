package commands;

import collection.CollectionManager;
import commands.manager.Command;
public class MinByColor extends Command {
    CollectionManager collectionManager = new CollectionManager();

    @Override
    protected void execute(String[] commandName) {
        collectionManager.min_by_color();
    }
}
