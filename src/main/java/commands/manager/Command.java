package commands.manager;

import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class Command {
    protected abstract void execute(String[] commandName);

}