package softeng.aueb.restaurant.ui.login;

import softeng.aueb.restaurant.dao.daoInf.CustomerDAO;
import softeng.aueb.restaurant.dao.daoInf.EmployeeDAO;
import softeng.aueb.restaurant.dao.daoInf.OwnerDAO;
import softeng.aueb.restaurant.domain.Customer;
import softeng.aueb.restaurant.domain.Employee;
import softeng.aueb.restaurant.domain.Owner;
import softeng.aueb.restaurant.util.RegexUtil;

public class LoginPresenter {
    LoginView view;
    CustomerDAO customerDAO;
    OwnerDAO ownerDAO;
    EmployeeDAO employeeDAO;

    public LoginPresenter(LoginView view, CustomerDAO customerDAO, OwnerDAO ownerDAO, EmployeeDAO employeeDAO) {
        this.view = view;
        this.customerDAO = customerDAO;
        this.ownerDAO = ownerDAO;
        this.employeeDAO = employeeDAO;
    }

    void onLogin() {
        if (view.getUsername().isEmpty() || view.getPassword().isEmpty()) {
            view.showEmptyFieldsDetected();
            return;
        }
        Object loginEntity = customerDAO.find(view.getUsername());
        if (loginEntity == null) {
            loginEntity = ownerDAO.find(view.getUsername());
        }
        if(loginEntity == null){
            loginEntity = employeeDAO.find(view.getUsername());
        }
        if (loginEntity instanceof Customer){
            if(((Customer) loginEntity).getPassword().equals(view.getPassword()))
                view.showSuccessCustomerLogin();
            else
                view.showFailedLogin();
        }
        if (loginEntity instanceof Owner){
            if(((Owner) loginEntity).getPassword().equals(view.getPassword()))
                view.showSuccessOwnerLogin();
            else
                view.showFailedLogin();
        }
        if (loginEntity instanceof Employee){
            if(((Employee) loginEntity).getPassword().equals(view.getPassword()))
                view.showSuccessEmployeeLogin(((Employee) loginEntity).getJob());
            else
                view.showFailedLogin();
        }

        if (loginEntity == null){
            view.showFailedLogin();
        }
    }
}
