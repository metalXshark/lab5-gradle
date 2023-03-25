package commands;

import collection.CollectionManager;
import commands.manager.Command;

public class RemoveHead extends Command {
    @Override
    protected void execute(String[] commandName) {
        try{
            collectionManager.remove_head();
            successResult();
        } catch (Exception e){
            errorResult(commandName[0], e);
        }
    }
}
