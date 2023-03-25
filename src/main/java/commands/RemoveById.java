package commands;

import commands.manager.Command;
import dragon.Dragon;

public class RemoveById extends Command {
    public boolean checkID(Long ID) {
        for (Dragon dragon : collectionManager.getLinkedList()) {
            if(dragon.getId().equals(ID)){
                return true;
            }
        }
        return false;
    }
    @Override
    protected void execute(String[] commandName) {
        try {
            Long dragonID = Long.parseLong(commandName[1]);
            if (checkID(dragonID)){
                collectionManager.remove_by_id(dragonID);
                successResult();
            } else {
                errorMassage("Элемента с таким ID нет в коллекции.");
            }
        } catch (Exception e){
            errorResult(commandName[0], e);
        }
    }
}
