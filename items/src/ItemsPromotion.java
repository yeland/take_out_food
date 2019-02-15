import java.util.ArrayList;

public class ItemsPromotion {
    private String type;
    private float sumPrice;
    private float savePrice;
    private String halfItems;

    public ItemsPromotion(String type, float sumPrice, float savePrice) {
        this.type = type;
        this.sumPrice = sumPrice;
        this.savePrice = savePrice;
    }

    public String getType() {
        return type;
    }

    public float getSumPrice() {
        return sumPrice;
    }

    public float getSavePrice() {
        return savePrice;
    }

    public String getHalfItems() {
        return halfItems;
    }

    public void setHalfItems(Item[] items) {
        ArrayList<String> findHalfItems = new ArrayList<String>();
        for (int i = 0; i < items.length; i++) {
            if (items[i].getType().equals("half")) {
                findHalfItems.add(items[i].getName());
            }
        }
        this.halfItems = String.join("，", findHalfItems);
    }
}
