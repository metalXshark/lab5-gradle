package commands.manager;

import collection.CollectionManager;
import console.ConsolePrinter;

public abstract class Command {
    private String name;

    protected abstract void execute(String[] commandName);

    protected CollectionManager collectionManager = new CollectionManager();

    protected ConsolePrinter consolePrinter = new ConsolePrinter();
    protected CommandManager commandManager = new CommandManager();

    protected void errorResult(String cmd, Exception e){
        consolePrinter.print(CommandResult.ERROR_MASSAGE.getResult() + cmd + ": " + e);
    }
    protected void successResult(){
        consolePrinter.print(CommandResult.SUCCESS_MASSAGE.getResult());
    }
    protected void errorMassage(String massage){
        consolePrinter.print(CommandResult.ERROR.getResult() + ": " + massage);
    }
}