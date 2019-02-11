import java.util.Arrays;
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
        System.out.println("输入数据：" + half.getHalfItems());
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

    public String generateItems(Item[] items) {
        String[] itemsString = new String[items.length];
        for(int i=0; i<items.length;i++) {
            itemsString[i] = items[i].getName() + " x " + items[i].getAmount() + " = " + items[i].getAllPrice();
        }
        return String.join("\n",itemsString);
    }

    public String generateCut(ItemsCut cut) {
//        final String dot = "-----------------------------------\n";
        if (cut.getType().equals("满30减6元")) {
            return "使用优惠：\n" + cut.getType() + "，省" + cut.getSavePrice() + "元\n";
        } else {
            return "";
        }
    }

    public String generateHalfString(ItemsHalf half) {
        if (half.getType().equals("指定菜品半价")) {
            return "使用优惠：\n" + half.getType() + half.getHalfItems() + "，省" + half.getSavePrice() + "元";
        } else {
            return "";
        }
    }
}
