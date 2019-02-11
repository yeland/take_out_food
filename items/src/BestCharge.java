import java.util.Scanner;

public class BestCharge {
    public static void main(String[] args) {
        System.out.print("请输入菜品名称和数量（格式：名称x数量，名称x数量，…）：");
        Scanner scan = new Scanner(System.in);
        String read = scan.nextLine();
        BestCharge best = new BestCharge();
        Item[] items = best.stringToItems(read);
        Promotions promotions = new Promotions();
        ItemsPromotion cut = promotions.getItemsCut(items);
        ItemsPromotion half = promotions.getItemsHalf(items);
        best.printToString(items,cut,half);
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

    public void printToString(Item[] items, ItemsPromotion cut, ItemsPromotion half) {
        final String header = "============= 订餐明细 =============\n";
        final String bottom = "===================================";
        String promotionString = comparePromotions(cut,half);
        String output = header + generateItems(items) + "\n" + promotionString + bottom;
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
        final String dot = "-----------------------------------\n";
        if (cut.getType().equals("满30减6元")) {
            cutString = dot + "使用优惠：\n" + cut.getType() + "，省" + cut.getSavePrice() + "元\n";
        } else {
            cutString = "";
        }
        return cutString + "-----------------------------------\n" + "总计：" + cut.getSumPrice() + "元\n";
    }

    public String generateHalfString(ItemsPromotion half) {
        String halfString;
        final String dot = "-----------------------------------\n";
        if (half.getType().equals("指定菜品半价")) {
            halfString = dot + "使用优惠：\n" +
                    half.getType() + "(" + half.getHalfItems() + ")，省" + half.getSavePrice() + "元\n";
        } else {
            halfString = "";
        }
        return halfString + "-----------------------------------\n" + "总计：" + half.getSumPrice() + "元\n";
    }
}
