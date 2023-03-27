package commands.manager;

import collection.CollectionManager;
import dragon.*;

import java.util.ArrayList;
import java.util.Scanner;

public class CreateObject {
    static CollectionManager collectionManager = new CollectionManager();

    public static Dragon createDragon(ArrayList<String> list){
        String name = list.get(0);
        float x = Float.parseFloat(list.get(1));
        long y = Long.parseLong(list.get(2));
        long age = Long.parseLong(list.get(3));
        Color color = Color.valueOf(list.get(4));
        DragonType type = DragonType.valueOf(list.get(5));
        DragonCharacter character = DragonCharacter.valueOf(list.get(6));
        String nameKiller = list.get(7);
        long height = Long.parseLong(list.get(8));
        long weight = Long.parseLong(list.get(9));
        String passportID = list.get(10);
        Color eyecolor = Color.valueOf(list.get(11));
        Coordinates coordinates =  new Coordinates(x, y);
        Person killer = new Person(nameKiller, height, weight, passportID, eyecolor);
        return new Dragon(name, coordinates, age, color, type, character, killer);
    }
    public static void updateDragon(Long id, ArrayList<String> list){
        float x = Float.parseFloat(list.get(1));
        long y = Long.parseLong(list.get(2));
        String nameKiller = list.get(7);
        long height = Long.parseLong(list.get(8));
        long weight = Long.parseLong(list.get(9));
        String passportID = list.get(10);
        Color eyecolor = Color.valueOf(list.get(11));
        Coordinates coordinates =  new Coordinates(x, y);
        Person killer = new Person(nameKiller, height, weight, passportID, eyecolor);
        collectionManager.getLinkedList().forEach(Dragon -> {
            if (Dragon.getId().equals(id)) {
                Dragon.setName(list.get(0));
                Dragon.setCoordinates(coordinates);
                Dragon.setAge(Long.parseLong(list.get(3)));
                Dragon.setColor(Color.valueOf(list.get(4)));
                Dragon.setType(DragonType.valueOf(list.get(5)));
                Dragon.setCharacter(DragonCharacter.valueOf(list.get(6)));
                Dragon.setKiller(killer);
            }
        });
    }
}
