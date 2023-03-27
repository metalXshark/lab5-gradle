package console;

import commands.manager.CommandResult;

public class ConsolePrinter implements IConsolePrinter{
    public void print(String e){
        System.out.print(e);
    }
}
