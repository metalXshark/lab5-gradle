package collection;

import console.ConsolePrinter;
import dragon.Color;
import dragon.Dragon;
import json.JsonManager;

import java.time.ZonedDateTime;
import java.util.*;

import static collection.CollectionInfo.getInfo;
import static collection.CollectionInfo.getInfoKiller;

public class CollectionManager implements ICollectionManager {
    private static LinkedList<Dragon> collection;
    private static ZonedDateTime creationDate;
    private static final ArrayList<Color> color = new ArrayList<>(List.of(Color.values()));
    private static final Set<String> group_names = new HashSet<>();
    ConsolePrinter consolePrinter = new ConsolePrinter();

    public void createCollection() {
        collection = new LinkedList<>();
        creationDate = ZonedDateTime.now();
    }
    public LinkedList<Dragon> getLinkedList() {
        return collection;
    }
    public ZonedDateTime getCreationDate(){
        return creationDate;
    }
    public void addJsonObject(Dragon dragon) {
        collection.add(dragon);
    }
    public boolean checkID(Long ID) {
        for (Dragon dragon : getLinkedList()) {
            if(dragon.getId().equals(ID)){
                return true;
            }
        }
        return false;
    }
    public boolean checkColor() {
        for (Dragon dragon : getLinkedList()) {
            if(dragon.getColor().equals(color.get(0))){
                return true;
            }
        }
        return false;
    }



    public void add(Dragon dragon) {
        collection.add(dragon);
    }
    public void clear() {
        collection.clear();
    }
    public void exit(){
        System.exit(0);
    }
    public void show() {
        collection.forEach(CollectionInfo::getInfo);
    }
    public void save(){
        JsonManager jsonManager = new JsonManager();
        jsonManager.collectionToJson();
    }
    public void print_field_ascending_killer(){
        for(Dragon dragon : getLinkedList()) {
            getInfoKiller(dragon.getKiller());
        }
    }
    public void remove_first(){
        if (collection.size() > 0) {
            collection.remove(collection.getFirst());
        } else {
            consolePrinter.print("Коллекция пуста.");
        }
    }
    public void remove_head(){
        if (collection.size() > 0) {
            getInfo(collection.getFirst());
            collection.remove(collection.getFirst());
        } else {
            consolePrinter.print("Коллекция пуста.");
        }
    }
    int k = 0;
    public int min_by_color(){
        if (checkColor()){
            Iterator<Dragon> i = collection.iterator();
            while (i.hasNext()) {
                Dragon dragon = i.next();
                if (dragon.getColor().equals(color.get(0))) {
                    getInfo(dragon);
                    k += 1;
                }
            }
            return k;
        } else {
            consolePrinter.print("Объекта с цветом " + color.get(0) + " не существует");
        }
        return 0;
    }
    public Set<String> group_counting_by_name(){
        for (Dragon dragon : getLinkedList()) {
            int k = 0;
            String name = dragon.getName();
            Iterator<Dragon> i = collection.iterator();
            while (i.hasNext()) {
                Dragon dragon1 = i.next();
                if (dragon1.getName().equals(name)) {
                    k += 1;
                }
            }
            String f = name + ": " + k;
            group_names.add(f);
        }
        return group_names;
    }
    public void remove_by_id(String ID) {
        Long dragonID;
        try {
            dragonID = Long.parseLong(ID);
            if (checkID(dragonID)) {
                Iterator<Dragon> i = collection.iterator();
                while (i.hasNext()) {
                    Dragon dragon = i.next();
                    if (dragon.getId().equals(dragonID)) {
                        i.remove();
                    }
                }
            } else {
                consolePrinter.print("Элемента с таким ID нет в коллекции.");
            }
        } catch (NumberFormatException e) {
            consolePrinter.print("Команда не выполнена. Вы ввели некорректный аргумент.");
        }
    }
}
