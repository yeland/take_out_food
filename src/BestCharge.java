import model.Item;
import model.ItemsPromotion;
import service.GetItems;
import service.Promotions;
import tools.Input;
import tools.Print;


public class BestCharge {
    public static void main(String[] args) {
        Input input = new Input();
        Item[] items = GetItems.stringToItems(input.getInput());
        Promotions promotions = new Promotions();
        ItemsPromotion finalPromotion = promotions.getFinalPromotion(items);
        Print.printToString(items, finalPromotion);
    }
}
