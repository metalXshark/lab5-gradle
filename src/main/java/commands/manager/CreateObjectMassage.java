package commands.manager;

import console.ConsolePrinter;

public enum CreateObjectMassage {
    MASSAGE_1("Введите имя дракона: "),
    MASSAGE_2("Введите местоположение дракона:\nX - "),
    MASSAGE_3("Y - "),
    MASSAGE_4("Введите возраст дракона: "),
    MASSAGE_5("(BLUE, ORANGE, WHITE, BROWN)\nВведите цвет дракона из представленных: "),
    MASSAGE_6("(UNDERGROUND, AIR, FIRE)\nВведите тип дракона из представленных: "),
    MASSAGE_7("(GOOD, CHAOTIC, CHAOTIC_EVIL, FICKLE)\nВведите характер дракона из представленных: "),
    MASSAGE_8("Введите имя убийцы дракона: "),
    MASSAGE_9("Введите рост убийцы: "),
    MASSAGE_10("Введите вес убийцы: "),
    MASSAGE_11("Введите ID паспорта убийцы: "),
    MASSAGE_12("(BLUE, ORANGE, WHITE, BROWN)\nВведите цвет глаз убийцы из представленных: "),
    ERROR_MASSAGE_1("#Error (Данное поле не может быть пустым.)"),
    ERROR_MASSAGE_2("#Error (Значение поля должно быть больше -572.)"),
    ERROR_MASSAGE_3("#Error (Вы ввели неподходящее значение.)"),
    ERROR_MASSAGE_4("#Error (Значение поля должно быть больше 0.)"),
    ERROR_MASSAGE_5("#Error (Длинна строки не должна превышать 44-х.)");
    private final String message;
    ConsolePrinter consolePrinter = new ConsolePrinter();
    CreateObjectMassage(String message){
        this.message = message;
    }
    public String getMessage(){
        consolePrinter.print(message);
        return message;
    }
}
