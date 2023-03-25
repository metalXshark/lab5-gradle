package collection;

import dragon.Dragon;

import java.util.Set;

public interface ICollectionManager {
    void add(Dragon dragon);
    void clear();
    void show();
    void exit();
    void save();
    void print_field_ascending_killer();
    void remove_first();
    void remove_head();
    int min_by_color();
    Set<String> group_counting_by_name();
    void remove_by_id(String ID);
}
