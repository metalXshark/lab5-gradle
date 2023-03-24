package commands;

import collection.CollectionManager;
import commands.manager.Command;
import console.ConsolePrinter;

public class Info extends Command {
    CollectionManager collectionManager = new CollectionManager();
    ConsolePrinter consolePrinter = new ConsolePrinter();

    @Override
    protected void execute(String[] commandName) {
        consolePrinter.print("Тип коллекции – " + collectionManager.getLinkedList().getClass().getName() + "\nДата инициализации коллекции – " + collectionManager.getCreationDate() + "\nКоличество элементов в коллекции – " + collectionManager.getLinkedList().size());
    }
}
