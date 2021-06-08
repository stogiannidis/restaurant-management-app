package softeng.aueb.restaurant.ui.login;

interface LoginView {


    String getUsername();

    void setUsername(String username);

    String getPassword();

    void setPassword(String password);


    void showEmptyFieldsDetected();

    void showFailedLogin();

    void showSuccessCustomerLogin();

    void showSuccessOwnerLogin();

    void showSuccessEmployeeLogin(String job);

    void showInvalidEmail();

}
