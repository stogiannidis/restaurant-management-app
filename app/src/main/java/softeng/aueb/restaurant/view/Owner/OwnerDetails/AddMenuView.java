package softeng.aueb.restaurant.view.Owner.OwnerDetails;

public interface AddMenuView {
    void onSuccessfulAddition();

    String getName();

    void setName(String name);

    String getPrice();

    void setPrice(String price);

    String getQuantity();

    void setQuantity(String quantity);

    void showEmptyFieldsDetected();

    void showProductAlreadyExists();

    void showInvalidProduct();

    void onExit();
}
