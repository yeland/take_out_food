package service;

import model.Item;

public class GetItems {
    public static Item[] stringToItems(String read) {
        String[] itemsString = read.split("，");
        Item[] items = new Item[itemsString.length];
        for (int i = 0; i < items.length; i++) {
            String name = itemsString[i].split("x")[0];
            int amount = Integer.parseInt(itemsString[i].split("x")[1]);
            items[i] = new Item(name, amount);
        }
        return items;
    }
}
