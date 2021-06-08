package softeng.aueb.restaurant.register.CustomerRegister;

public interface CustomerRegView {
    void onSuccessfulRegister();

    String getEmail();

    void setEmail(String email);

    String getUsername();

    void setUsername(String username);

    String getPassword();

    void setPassword(String password);


    void showEmptyFieldsDetected();

    void showEmailAlreadyExists();

    void showInvalidEmail();
}
