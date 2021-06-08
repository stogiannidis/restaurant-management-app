package softeng.aueb.restaurant.view.Employee.EmployeeDetails;

public interface OrderManagementView {
    void onSuccessfulVerification();

    String getOrderID();

    void setOrderID(String name);

    String getPrepationTime();

    void setPreparationTime(String preparationTime);

    void showEmptyFieldsDetected();

    void showInvalidOrder();

    void onExit();
}
