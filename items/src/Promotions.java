public class Promotions {
    public ItemsPromotion getItemsCut(Item[] items) {
        float totalPrice = getTotalPrice(items);
        float sumPrice;
        if (totalPrice > 30) {
            sumPrice = totalPrice - 6;
            float savePrice = 6;
            return new ItemsPromotion("满30减6元",sumPrice, savePrice);
        } else {
            return new ItemsPromotion("无",totalPrice, 0);
        }
    }

    public ItemsPromotion getItemsHalf(Item[] items) {
        float sumPrice = 0;
        String type = "无";
        for (int i = 0; i < items.length; i++) {
            if (items[i].getType().equals("half")) {
                type = "指定菜品半价";
                sumPrice += items[i].getAllPrice() / 2;
            } else {
                sumPrice += items[i].getAllPrice();
            }
        }
        float totalPrice = getTotalPrice(items);
        ItemsPromotion half = new ItemsPromotion(type, sumPrice, totalPrice - sumPrice);
        half.setHalfItems(items);
        return half;
    }

    private static float getTotalPrice(Item[] items) {
        float totalPrice = 0;
        for (int i = 0; i < items.length; i++) {
            totalPrice += items[i].getAllPrice();
        }
        return totalPrice;
    }
}

