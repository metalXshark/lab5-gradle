package commands;

import collection.CollectionManager;
import commands.manager.Command;

public class RemoveFirst extends Command {
    @Override
    protected void execute(String[] commandName) {
        try{
            collectionManager.remove_first();
            successResult();
        } catch (Exception e){
            errorResult(commandName[0], e);
        }

    }
}
