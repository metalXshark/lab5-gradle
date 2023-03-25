package commands;

import commands.manager.Command;
import commands.manager.CreateObject;
import dragon.Dragon;

public class Update extends Command {
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
        Long dragonID;
        try {
            dragonID = Long.parseLong(commandName[1]);
            if (checkID(dragonID)) {
                Dragon updateDragon = CreateObject.createDragon();
                collectionManager.getLinkedList().forEach(Dragon -> {
                    if (Dragon.getId().equals(dragonID)) {
                        Dragon.setName(updateDragon.getName());
                        Dragon.setCoordinates(updateDragon.getCoordinates());
                        Dragon.setAge(updateDragon.getAge());
                        Dragon.setColor(updateDragon.getColor());
                        Dragon.setType(updateDragon.getType());
                        Dragon.setCharacter(updateDragon.getCharacter());
                        Dragon.setKiller(updateDragon.getKiller());
                    }
                });
            } else {
                errorMassage("Элемента с таким ID нет в коллекции.");
            }
        } catch (Exception e) {
            errorResult(commandName[0], e);
        }
    }
}
