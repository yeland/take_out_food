package tools;

import model.Item;
import model.ItemsPromotion;

public class Print {
    public static void printToString(Item[] items, ItemsPromotion promotion) {
        final String HEADER = "============= 订餐明细 =============\n";
        final String BOTTOM = "===================================";
        String promotionString = generatePromotion(promotion);
        String output = HEADER + generateItems(items) + "\n" + promotionString + BOTTOM;
        System.out.println(output);
    }

    public static String generateItems(Item[] items) {
        String[] itemsString = new String[items.length];
        for (int i = 0; i < items.length; i++) {
            itemsString[i] = items[i].getName() + " x " + items[i].getAmount() + " = " + items[i].getAllPrice();
        }
        return String.join("\n", itemsString);
    }

    public static String generatePromotion(ItemsPromotion promotion) {
        final String DOT = "-----------------------------------\n";
        String promotionString;
        switch (promotion.getType()) {
            case "满30减6元":
                promotionString = DOT + "使用优惠：\n" + promotion.getType() +
                        "，省" + promotion.getSavePrice() + "元\n";
                break;
            case "指定菜品半价":
                promotionString = DOT + "使用优惠：\n" + promotion.getType() +
                        "(" + promotion.getHalfItems() + ")，省" + promotion.getSavePrice() + "元\n";
                break;
            default:
                promotionString = "";
                break;
        }
        return promotionString + "-----------------------------------\n" +
                "总计：" + promotion.getSumPrice() + "元\n";
    }
}
