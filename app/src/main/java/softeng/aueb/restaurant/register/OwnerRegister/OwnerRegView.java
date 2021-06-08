package softeng.aueb.restaurant.register.OwnerRegister;

public interface OwnerRegView {

    void onSuccessfulRegister();

    String getEmail();

    void setEmail(String email);

    String getUsername();

    void setUsername(String username);

    String getPassword();

    void setPassword(String password);

    void setTables(String numberOfTables);

    String getTables();

    void showEmptyFieldsDetected();

    void showEmailAlreadyExists();

    void showInvalidEmail();
}