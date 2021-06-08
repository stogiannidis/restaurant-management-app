package softeng.aueb.restaurant.domain;


/**
 * A class that implements an item of the menu
 * in our system
 * @author team23
 */
public class MenuItem {

    private String name;
    private int quantity;

    /**
     * Class Constructor
     * @param name item's name
     * @param quantity item's quantity for the order
     */
    public MenuItem(String name, int quantity) {
        this.name = name;
        this.quantity=quantity;
    }

    /**
     * Modifies the quantity of the item in the current order
     * @param number extra new quantity or pieces to be cancelled
     */
    public void modifyQuantity(int number){
        if(quantity-number > 0)
            quantity+=number;
        else
            quantity=0;
    }

    /**
     * Getter
     * @return item's name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter
     * @param name item's new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter
     * @return item's quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Setter
     * @param quantity item's new quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
