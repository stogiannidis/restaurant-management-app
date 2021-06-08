package softeng.aueb.restaurant.view.Customer.ViewOrder;

public interface ViewOrderStatusView {
    void setTime(String time);

    String getTime();

    void setOrderID(String id);

    String getOrderID();

    void setPrice(String price);

    String getPrice();

    void OnPayment();
}
