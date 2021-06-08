package softeng.aueb.restaurant.view.Owner.OwnerDetails;

import softeng.aueb.restaurant.dao.daoInf.ProductItemDAO;
import softeng.aueb.restaurant.domain.ProductItem;

/**
 * Class that connects the view with domain
 */

public class AddMenuPresenter {
    ProductItemDAO itemDAO;
    AddMenuView view;

    public AddMenuPresenter(ProductItemDAO itemDAO, AddMenuView view) {
        this.itemDAO = itemDAO;
        this.view = view;
    }

    /**
     * Adds an items given in the app view to the restaurant's menu
     * by contacting the domain classes and the DAOs
     */
    public void onAddition() {
        double price = .0;
        int quantity = 0;
        if(view.getName().isEmpty()|| view.getPrice().isEmpty() || view.getQuantity().isEmpty()){
            view.showEmptyFieldsDetected();
            return;
        }

        if(itemDAO.find(view.getName()) != null){
            view.showProductAlreadyExists();
            return;
        }
        try {
            price = Double.parseDouble(view.getPrice());
        }catch (Exception e){
            view.showInvalidProduct();
            return;
        }
        try {
            quantity = Integer.parseInt(view.getQuantity());
        }catch (Exception e){
            view.showInvalidProduct();
            return;
        }
        ProductItem product = new ProductItem(view.getName(),price,quantity);

        itemDAO.save(product);

        view.onSuccessfulAddition();
    }
}
