package json;

import collection.CollectionManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import dragon.Dragon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class JsonManager {
    public  String filePath = System.getenv("Json_file");
    private final GsonBuilder builder = new GsonBuilder();
    private final Gson gson = builder
            .serializeNulls()
            .setPrettyPrinting()
            .enableComplexMapKeySerialization()
            .create();
    public void fromJsonToCollection() {
        if (filePath != null) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                CollectionManager collectionManager = new CollectionManager();
                System.out.println();
                collectionManager.createCollection();
                List<Dragon> Dragon = gson.fromJson(reader, new TypeToken<List<Dragon>>() {
                }.getType());
                if (Dragon.size() > 0) for (Dragon dragon : Dragon) {
                    collectionManager.addJsonObject(dragon);
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } catch (SecurityException e) {
                System.out.println("Недостаточно прав для открытия файла.");
            } catch (NullPointerException e) {
                System.out.println("В файле нет объектов");
            } catch (com.google.gson.JsonSyntaxException e) {
                System.out.println("Ошибка в содержании файла " + e.getMessage());
            }
        } else {
            System.out.println("Переменная окружения не выставлена");
        }
    }
    public void collectionToJson() {
        try (PrintWriter writer = new PrintWriter(filePath)) {
            CollectionManager collectionManager = new CollectionManager();
            gson.toJson(collectionManager.getLinkedList(), writer);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}