package collection;

import dragon.Dragon;
import dragon.Person;

public class CollectionInfo {
    public static void getInfo(Dragon dragon) {
        System.out.println("ID элемента коллекции   -  " + dragon.getId());
        System.out.println("Имя дракона             -  " + dragon.getName());
        System.out.println("Координаты дракона      -  " + "X - " + dragon.getCoordinates().getX() + "; Y - " + dragon.getCoordinates().getY());
        System.out.println("Дата создания элемента  -  " + dragon.getCreationDate());
        System.out.println("Возраст дракона         -  " + dragon.getAge());
        System.out.println("Цвет дракона            -  " + dragon.getColor());
        System.out.println("Тип дракона             -  " + dragon.getType());
        System.out.println("Характер дракона        -  " + dragon.getCharacter());
        System.out.println("Убийца дракона          -  " + dragon.getKiller().getName());
        System.out.println("---------------------------------------------------------");
    }
    public static void getInfoKiller(Person person) {
        System.out.println("ID паспорта -  " + person.getPassportID());
        System.out.println("Имя убийцы  -  " + person.getName());
        System.out.println("Рост        -  " + person.getHeight());
        System.out.println("Вес         -  " + person.getWeight());
        System.out.println("Цвет глаз   -  " + person.getEyeColor());
        System.out.println("---------------------------------------------");
    }
}
