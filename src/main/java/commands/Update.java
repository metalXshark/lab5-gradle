package commands;

import collection.CollectionManager;
import commands.manager.Command;
import commands.manager.CreateObject;
import console.ConsolePrinter;
import dragon.Dragon;

public class Update extends Command {
    CollectionManager collectionManager = new CollectionManager();
    ConsolePrinter consolePrinter = new ConsolePrinter();
    @Override
    protected void execute(String[] commandName) {
        Long dragonID;
        try {
            dragonID = Long.parseLong(commandName[1]);
            if (collectionManager.checkID(dragonID)) {
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
                consolePrinter.print("Элемента с таким ID нет в коллекции.");
            }
        } catch (NumberFormatException e) {
            consolePrinter.print("Команда не выполнена. Вы ввели некорректный аргумент.");
        }
    }
}
