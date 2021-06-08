package softeng.aueb.restaurant.domain;

import java.util.ArrayList;

/**
 * Class that implements an order in our App
 * @authors team23
 */
public class Order {
    private int orderNumber;
    private boolean isPaid = false;
    private boolean verified = false;
    private int preparationTime;
    public ArrayList<ProductItem> available = new ArrayList<>();
    public ArrayList<MenuItem> basket = new ArrayList<>();

    /**
     * Class Constructor
     * @param orderNumber number of the Order
     *                    works as its ID
     */
    public Order(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * Adds an item to the order's
     * basket
     * @param item the items to be added
     */
    public void addItem(MenuItem item){
        basket.add(item);
    }

    /**
     * Removes an item from
     * the order's basket
     * @param item item to be removed
     */
    public void removeItem(MenuItem item){
        if (basket.contains(item)) {
            basket.remove(item);
            item.modifyQuantity(1);
        }
    }

    /**
     * Clears order's basket
     */
    public void clearBasket(){
        if(!basket.isEmpty()){
            for(ProductItem i : available){
                for(MenuItem is : basket){
                    if(i.getName().equals(is.getName())){
                        i.modifyQuantity(is.getQuantity());
                    }
                }
            }
            basket.clear();
        }
    }

    /**
     * Verifies the order
     */
    public void verify(){verified = true;}

    /**
     * Getter
     * @return {@code true} if verified
     * {@code false} else
     */
    public boolean getVerification(){return verified;}

    /**
     * Getter
     * @return order's numberID
     */
    public int getOrderNumber() {
        return orderNumber;
    }

    /**
     * Setter
     * @param orderNumber new order's ID
     */
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * Verifies if the order is paid or not
     * @return {@code true} if paid {@code false} else
     *
     */
    public boolean isPaid() {
        return isPaid;
    }

    /**
     * Setter
     * @param paid new order's state
     */
    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    /**
     * Getter
     * @return order's basket
     */
    public ArrayList<MenuItem> getBasket() {
        return basket;
    }

    /**
     * Finds if an item is in the order's basket
     * @param p
     * @return {@code true} if it is contained {@code false} else
     */
    public boolean isContained(MenuItem p){
        return basket.contains(p);
    }

    /**
     * Getter
     * @return order's total preparation time
     */
    public int getPreparationTime() {
        return preparationTime;
    }

    /**
     * Setter
     * @param preparationTime order's preparation time
     */
    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }
}