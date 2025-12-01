package project;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class ProjectDatabase {

    private Map<Integer, Item> database = new HashMap<>();

    public void addItem(Item item) {
        int i = database.size() + 1;
        item.setItemId(i);
        database.put(item.getId(), item);
    }

    public void sortedCustomer(List <Item> items) {
        Collections.sort(items);
        for (Item item : items) {
            addItem(item);
        }
        for (Map.Entry<Integer, Item> entry : database.entrySet()) {
            Integer key = entry.getKey();
            Item value = entry.getValue();
            System.out.println("key: " + key + ", value: " + value);
        }

    }

    public void removeItemById(int id) {
        database.remove(id);
        System.out.println("removed item with id " + id);
    }

    public void removeItemByName(String name) {
        Iterator<Map.Entry<Integer, Item>> it = database.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Item> entry = it.next();
            if (entry.getValue().getName().equalsIgnoreCase(name)) {
                it.remove();
            }
        }
        System.out.println("removed item with name " + name);
    }


    public void findItem(int id) {
        Item  item = database.get(id);
        System.out.println("item found on id: "+ id + "info about id: "+item.toString());
    }

    public List<Item> top5Items() {
        List<Item> list = new ArrayList<>(database.values());
        list.sort(new Comparator<Item>() {
            @Override
            public int compare(Item a, Item b) {
                return b.getQuantity() - a.getQuantity();
            }
        });
        List<Item> result = new ArrayList<>();
        for (int i = 0; i < list.size() && i < 5; i++) {
            result.add(list.get(i));
        }
        return result;
    }


    public void groupByCategory() {
        Map<String, Integer> group = new HashMap<>();

        for (Item item : database.values()) {
            String category = item.getCategory();

            if (group.containsKey(category)) {
                group.compute(category, (k, oldValue) -> oldValue + 1);
            }
            else {
                group.put(category, 1);
            }
        }

        for (String category : group.keySet()) {
            System.out.println(category + ": " + group.get(category) + " products");
        }
    }

    public void saveToFile(String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(database);
            System.out.println("database saved");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            database = (Map<Integer, Item>) in.readObject();
            System.out.println("database loaded");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
