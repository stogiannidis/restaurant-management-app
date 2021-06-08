package softeng.aueb.restaurant.domain;


/**
 * A class that implements an items in our system
 * @author team23
 */

public class ProductItem {

    private String name="";
    private double cost=0; //cost per item

    private int quantityMade=0;


    /**
     * Class constructor
     * @param name item's name
     * @param cost item's cost
     * @param quantity item's quantity
     */
    public ProductItem(String name, double cost, int quantity) {
        this.name = name;
        this.cost = cost;
        quantityMade=quantity;

    }

    /**
     * Modifies the quantity of the item based on input parameter
     * @param number number use to modify quantity
     */
    public void modifyQuantity(int number){
        if(quantityMade-number > 0)
            quantityMade+=number;
        else
            quantityMade=0;
    }

    /**
     * Getter
     * @return total possible quantity of the item
     */
    public int getQuantityMade() {
        return quantityMade;
    }

    /**
     * Setter
     * @param quantityMade new item quantity
     */
    public void setQuantityMade(int quantityMade) {
        this.quantityMade = quantityMade;
    }

    /**
     * Getter
     * @return name of the item
     */
    public String getName() {
        return name;
    }

    /**
     * Setter
     * @param name new name of the item
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter
     * @return the cost of the item
     */
    public double getCost() {
        return cost;
    }

    /**
     * Setter
     * @param cost the new cost of the item
     */
    public void setCost(double cost) {
        this.cost = cost;
    }



}
