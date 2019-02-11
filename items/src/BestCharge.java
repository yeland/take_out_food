import java.util.Scanner;

public class BestCharge {
    public static void main(String[] args) {
        System.out.print("请输入菜品名称和数量（格式：名称x数量，名称x数量，…）：");
        Scanner scan = new Scanner(System.in);
        String read = scan.nextLine();
        BestCharge best = new BestCharge();
        Item[] items = best.stringToItems(read);
        Promotions promotions = new Promotions();
        ItemsCut cut = promotions.getItemsCut(items);
        ItemsHalf half = promotions.getItemsHalf(items);
        System.out.println("输入数据：" + half.getSumPrice());
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
}
