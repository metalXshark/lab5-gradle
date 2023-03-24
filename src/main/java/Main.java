import console.ConsoleManager;
import json.JsonManager;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        JsonManager jsonManager = new JsonManager();
        ConsoleManager console = new ConsoleManager();
        jsonManager.fromJsonToCollection();
        console.start();
    }
}

