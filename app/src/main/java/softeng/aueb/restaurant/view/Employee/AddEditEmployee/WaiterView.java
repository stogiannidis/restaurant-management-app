package softeng.aueb.restaurant.view.Employee.AddEditEmployee;

public interface WaiterView {
    void onSuccessfulVerification();
    String getOrderID();
    void setOrderID(String id);
    void showEmptyFieldsDetected();
    void showInvalidOrder();
    void onExit();
}
