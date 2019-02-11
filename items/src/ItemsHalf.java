public class ItemsHalf {
    private String type;
    private float sumPrice;
    private float savePrice;

    public ItemsHalf(String type, float sumPrice, float savePrice) {
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
}
