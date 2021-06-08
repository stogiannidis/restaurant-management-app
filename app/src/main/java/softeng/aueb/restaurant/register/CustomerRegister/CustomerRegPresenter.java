package softeng.aueb.restaurant.register.CustomerRegister;

import softeng.aueb.restaurant.dao.daoInf.CustomerDAO;
import softeng.aueb.restaurant.domain.Customer;
import softeng.aueb.restaurant.util.RegexUtil;

public class CustomerRegPresenter {

    CustomerRegView view;
    CustomerDAO customerDAO;

    public CustomerRegPresenter(CustomerRegView view, CustomerDAO customerDAO){
        this.customerDAO = customerDAO;
        this.view = view;
    }

    public void onRegister(){
        if (view.getEmail().isEmpty()|| view.getUsername().isEmpty() || view.getPassword().isEmpty()){
            view.showEmptyFieldsDetected();
            return;
        }
        if (!RegexUtil.isEmail(view.getEmail())) {
            view.showInvalidEmail();
            return;
        }

        if (customerDAO.isEmailTaken(view.getEmail())) {
            view.showEmailAlreadyExists();
            return;
        }


        Customer customer = new Customer(view.getUsername(), view.getEmail(), view.getPassword());

        customerDAO.save(customer);
        view.onSuccessfulRegister();
    }


}

