public class ItemsCut {
    private float sumPrice;
    private float savePrice;
    private String type;

    public ItemsCut(float sumPrice, float savePrice, String type) {
        this.sumPrice = sumPrice;
        this.savePrice = savePrice;
        this.type = type;
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
