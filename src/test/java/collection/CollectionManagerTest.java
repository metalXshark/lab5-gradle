package collection;

import console.ConsoleManager;
import dragon.*;
import json.JsonManager;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class CollectionManagerTest {

    public void start(){
        JsonManager jsonManager = new JsonManager();
        jsonManager.fromJsonToCollection();
    }

    @org.junit.jupiter.api.Test
    void getLinkedList() {
        CollectionManager collectionManager = new CollectionManager();
        assertNull(collectionManager.getLinkedList());
        start();
        assertNotNull(collectionManager.getLinkedList());
    }

    @org.junit.jupiter.api.Test
    void checkID() {
        CollectionManager collectionManager = new CollectionManager();
        start();
        String ID = "7694290539024656580";
        String ID1 = "984327077597855196";
        String ID2 = "3406456834465878423";
        Long dragonID = Long.parseLong(ID);
        Long dragonID1 = Long.parseLong(ID1);
        Long dragonID2 = Long.parseLong(ID2);
        assertTrue(collectionManager.checkID(dragonID));
        assertTrue(collectionManager.checkID(dragonID1));
        assertFalse(collectionManager.checkID(dragonID2));
    }

    @org.junit.jupiter.api.Test
    void add() {
        Coordinates coordinates = new Coordinates(12,12);
        Person killer = new Person("test", 12, 12, "12", Color.BLUE);
        Dragon dragon = new Dragon("test", coordinates, 12, Color.BLUE, DragonType.AIR, DragonCharacter.CHAOTIC, killer);
        start();
        CollectionManager collectionManager = new CollectionManager();
        collectionManager.add(dragon);
        assertEquals(5, collectionManager.getLinkedList().size());
    }

    @org.junit.jupiter.api.Test
    void clear() {
        CollectionManager collectionManager = new CollectionManager();
        start();
        assertNotNull(collectionManager.getLinkedList());
        collectionManager.clear();
        assertEquals(0, collectionManager.getLinkedList().size());
    }

    @org.junit.jupiter.api.Test
    void remove_first() {
        CollectionManager collectionManager = new CollectionManager();
        start();
        String x = String.valueOf(collectionManager.getLinkedList().getFirst());
        collectionManager.remove_first();
        String y = String.valueOf(collectionManager.getLinkedList().getFirst());
        assertNotEquals(x, y);
    }

    @org.junit.jupiter.api.Test
    void remove_head() {
        CollectionManager collectionManager = new CollectionManager();
        start();
        String x = String.valueOf(collectionManager.getLinkedList().getFirst());
        collectionManager.remove_head();
        String y = String.valueOf(collectionManager.getLinkedList().getFirst());
        assertNotEquals(x, y);
    }

    @org.junit.jupiter.api.Test
    void min_by_color() {
        CollectionManager collectionManager = new CollectionManager();
        start();
        assertEquals(2, collectionManager.min_by_color());
    }

    @org.junit.jupiter.api.Test
    void group_counting_by_name() {
        CollectionManager collectionManager = new CollectionManager();
        Coordinates coordinates = new Coordinates(12,12);
        Person killer = new Person("test", 12, 12, "12", Color.BLUE);
        Dragon dragon1 = new Dragon("test1", coordinates, 12, Color.BLUE, DragonType.AIR, DragonCharacter.CHAOTIC, killer);
        Dragon dragon2 = new Dragon("test1", coordinates, 12, Color.BLUE, DragonType.AIR, DragonCharacter.CHAOTIC, killer);
        Dragon dragon3 = new Dragon("test2", coordinates, 12, Color.BLUE, DragonType.AIR, DragonCharacter.CHAOTIC, killer);
        Dragon dragon4 = new Dragon("test3", coordinates, 12, Color.BLUE, DragonType.AIR, DragonCharacter.CHAOTIC, killer);
        collectionManager.createCollection();
        collectionManager.add(dragon1);
        collectionManager.add(dragon2);
        collectionManager.add(dragon3);
        collectionManager.add(dragon4);
        assertEquals("[test1: 2, test2: 1, test3: 1]", collectionManager.group_counting_by_name().toString());
    }

    @org.junit.jupiter.api.Test
    void remove_by_id() {
        CollectionManager collectionManager = new CollectionManager();
        start();
        String x = String.valueOf(collectionManager.getLinkedList().getFirst());
        collectionManager.remove_by_id("7694290539024656580");
        String y = String.valueOf(collectionManager.getLinkedList().getFirst());
        assertNotEquals(x, y);
    }
}