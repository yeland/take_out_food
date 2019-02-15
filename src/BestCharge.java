import model.Item;
import model.ItemsPromotion;
import service.Promotions;
import tools.Input;
import tools.Print;


public class BestCharge {
    public static void main(String[] args) {
        //示例输入：黄焖鸡x1，肉夹馍x2，凉皮x1（或：肉夹馍x4，凉皮x1;肉夹馍x4）
        BestCharge best = new BestCharge();
        Input input = new Input();
        Item[] items = best.stringToItems(input.getInput());
        best.getBestCharge(items);
    }

    public Item[] stringToItems(String read) {
        String[] itemsString = read.split("，");
        Item[] items = new Item[itemsString.length];
        for (int i = 0; i < items.length; i++) {
            String name = itemsString[i].split("x")[0];
            int amount = Integer.parseInt(itemsString[i].split("x")[1]);
            items[i] = new Item(name, amount);
        }
        return items;
    }

    public void getBestCharge(Item[] items) {
        Promotions promotions = new Promotions();
        ItemsPromotion finalPromotion = promotions.getFinalPromotion(items);
        Print.printToString(items, finalPromotion);
    }


}
