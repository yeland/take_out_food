package model;

public class Item {
    private String id;
    private String name;
    private String type;
    private int amount;
    private float price;
    private float allPrice;

    public Item(String name, int amount) {
        this.name = name;
        this.amount = amount;
        switch (name) {
            case "黄焖鸡":
                this.id = "ITEM0001";
                this.type = "half";
                this.price = 18.00f;
                break;
            case "肉夹馍":
                this.id = "ITEM0013";
                this.type = "total";
                this.price = 6.00f;
                break;
            case "凉皮":
                this.id = "ITEM0022";
                this.type = "half";
                this.price = 8.00f;
                break;
            case "冰峰":
                this.id = "ITEM0030";
                this.type = "total";
                this.price = 2.00f;
                break;
            default:
                break;
        }
        this.allPrice = this.price * this.amount;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public float getPrice() {
        return price;
    }

    public float getAllPrice() {
        return allPrice;
    }

    public String getType() {
        return type;
    }
}