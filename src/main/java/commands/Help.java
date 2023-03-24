package commands;

import commands.manager.Command;
import console.ConsolePrinter;

public class Help extends Command {
    ConsolePrinter consolePrinter = new ConsolePrinter();
    @Override
    protected void execute(String[] commandName) {
        consolePrinter.print("help : вывести справку по доступным командам\ninfo : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\nshow : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\nadd {element} : добавить новый элемент в коллекцию\nupdate id {element} : обновить значение элемента коллекции, id которого равен заданному\nremove_by_id id : удалить элемент из коллекции по его id\nclear : очистить коллекцию\nsave : сохранить коллекцию в файл\nexecute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в * * * интерактивном режиме\nexit : завершить программу (без сохранения в файл)\nremove_first : удалить первый элемент из коллекции\nremove_head : вывести первый элемент коллекции и удалить его\nhistory : вывести последние 14 команд (без их аргументов)\nmin_by_color : вывести любой объект из коллекции, значение поля color которого является минимальным\ngroup_counting_by_name : сгруппировать элементы коллекции по значению поля name, вывести количество элементов в каждой группе\nprint_field_ascending_killer : вывести значения поля killer всех элементов в порядке возрастания%n");
    }
}
