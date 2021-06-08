package softeng.aueb.restaurant.register.EmployeeRegister;

public interface EmployeeRegView {
    void onSuccessfulRegister();

    String getEmail();

    void setEmail(String email);

    String getUsername();

    void setUsername(String username);

    String getPassword();

    void setPassword(String password);

    String getJob();

    void showEmptyFieldsDetected();

    void showEmailAlreadyExists();

    void showInvalidEmail();
}
