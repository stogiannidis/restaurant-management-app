package softeng.aueb.restaurant.view.Customer.AddOrder;

public interface AddOrderView {

    void onSuccessfulAddition();

    String getName();

    void setName(String name);

    void showInvalidQuantity();

    String getQuantity();

    void setQuantity(String quantity);

    void showEmptyFieldsDetected();

    void showInvalidProduct();

    void onExit(int orderID);

    void setTable(String number);

    String getTable();

    void showInvalidTable();

    void onBasketClear();

}
