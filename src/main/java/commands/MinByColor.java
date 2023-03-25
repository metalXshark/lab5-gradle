package commands;

import collection.CollectionManager;
import commands.manager.Command;
import dragon.Color;
import dragon.Dragon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static collection.CollectionInfo.getInfo;

public class MinByColor extends Command {
    private static final ArrayList<Color> color = new ArrayList<>(List.of(Color.values()));
    public boolean checkColor() {
        for (Dragon dragon : collectionManager.getLinkedList()) {
            if(dragon.getColor().equals(color.get(0))){
                return true;
            }
        }
        return false;
    }
    @Override
    protected void execute(String[] commandName) {
        try {
            if (checkColor()){
                collectionManager.min_by_color();
                successResult();
            } else {
                errorMassage("Объекта с цветом " + color.get(0) + " не существует");
            }
        } catch (Exception e){
            errorResult(commandName[0], e);
        }
    }
}
