public class Promotions {
    public ItemsCut getItemsCut(Item[] items) {
        float totalPrice = getTotalPrice(items);
        float sumPrice;
        if (totalPrice > 30) {
            sumPrice = totalPrice - 6;
            float savePrice = 6;
            return new ItemsCut(sumPrice, savePrice, "满30减6元");
        } else {
            return new ItemsCut(totalPrice, 0, "无");
        }
    }

    public ItemsHalf getItemsHalf(Item[] items) {
        float sumPrice = 0;
        String type = "无";
        for(int i=0; i<items.length;i++) {
            if(items[i].getType().equals("half")) {
                type = "指定菜品半价";
                sumPrice += items[i].getAllPrice()/2;
            } else {
                sumPrice += items[i].getAllPrice();
            }
        }
        float totalPrice = getTotalPrice(items);
        return new ItemsHalf(type,sumPrice,totalPrice-sumPrice);
    }

    private static float getTotalPrice(Item[] items) {
        float totalPrice = 0;
        for (int i = 0; i < items.length; i++) {
            totalPrice += items[i].getAllPrice();
        }
        return totalPrice;
    }
}

