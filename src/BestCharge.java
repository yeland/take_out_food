import model.Item;
import model.ItemsPromotion;
import service.Promotions;

import java.util.Scanner;

public class BestCharge {
    public static void main(String[] args) {
        BestCharge best = new BestCharge();
        Item[] items = best.stringToItems(best.getInput());
        best.getBestCharge(items);
    }

    public String getInput() {
        System.out.print("请输入菜品名称和数量（格式：名称x数量，名称x数量，…）：");
        //示例输入：黄焖鸡x1，肉夹馍x2，凉皮x1（或：肉夹馍x4，凉皮x1;肉夹馍x4）
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
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
        ItemsPromotion cut = promotions.getItemsCut(items);
        ItemsPromotion half = promotions.getItemsHalf(items);
        printToString(items, cut, half);
    }

    public void printToString(Item[] items, ItemsPromotion cut, ItemsPromotion half) {
        final String HEADER = "============= 订餐明细 =============\n";
        final String BOTTOM = "===================================";
        String promotionString = comparePromotions(cut, half);
        String output = HEADER + generateItems(items) + "\n" + promotionString + BOTTOM;
        System.out.println(output);
    }

    public String comparePromotions(ItemsPromotion cut, ItemsPromotion half) {
        if (cut.getSumPrice() > half.getSumPrice()) {
            return generateHalfString(half);
        } else {
            return generateCutString(cut);
        }
    }

    public String generateItems(Item[] items) {
        String[] itemsString = new String[items.length];
        for (int i = 0; i < items.length; i++) {
            itemsString[i] = items[i].getName() + " x " + items[i].getAmount() + " = " + items[i].getAllPrice();
        }
        return String.join("\n", itemsString);
    }

    public String generateCutString(ItemsPromotion cut) {
        String cutString;
        final String DOT = "-----------------------------------\n";
        if (cut.getType().equals("满30减6元")) {
            cutString = DOT + "使用优惠：\n" + cut.getType() + "，省" + cut.getSavePrice() + "元\n";
        } else {
            cutString = "";
        }
        return cutString + "-----------------------------------\n" + "总计：" + cut.getSumPrice() + "元\n";
    }

    public String generateHalfString(ItemsPromotion half) {
        String halfString;
        final String DOT = "-----------------------------------\n";
        if (half.getType().equals("指定菜品半价")) {
            halfString = DOT + "使用优惠：\n" +
                    half.getType() + "(" + half.getHalfItems() + ")，省" + half.getSavePrice() + "元\n";
        } else {
            halfString = "";
        }
        return halfString + "-----------------------------------\n" + "总计：" + half.getSumPrice() + "元\n";
    }
}
