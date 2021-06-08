package softeng.aueb.restaurant.domain;

import java.util.ArrayList;

/**
 * Class that implements a table in our App
 * @authors team23
 */
public class Table {
    private int tableNumber;
    private double totalCost=0;

    public ArrayList<Order> dailyOrders = new ArrayList<>();

    /**
     * Class constructor
     * @param tableNumber tables identification number
     */
    public Table(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    /**
     * Relates and order with the table
     * @param order
     */
    public void addOrder(Order order){
        dailyOrders.add(order);
    }

    /**
     * Getter
     * @return table's identification number
     */
    public int getTableNumber() {
        return tableNumber;
    }

    /**
     * Setter
     * @param tableNumber table's new identification number
     */
    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    /**
     * Getter
     * @return table's total cost
     */
    public double getTotalCost() {
        return totalCost;
    }

}
