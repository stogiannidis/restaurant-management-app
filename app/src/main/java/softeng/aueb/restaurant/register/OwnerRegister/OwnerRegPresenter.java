package softeng.aueb.restaurant.register.OwnerRegister;

import softeng.aueb.restaurant.dao.daoInf.OwnerDAO;
import softeng.aueb.restaurant.dao.daoInf.TableDAO;
import softeng.aueb.restaurant.domain.Customer;
import softeng.aueb.restaurant.domain.Owner;
import softeng.aueb.restaurant.domain.Table;
import softeng.aueb.restaurant.util.RegexUtil;

public class OwnerRegPresenter {

    OwnerRegView view;
    OwnerDAO ownerDAO;
    TableDAO tableDAO;

    public OwnerRegPresenter(OwnerRegView view, OwnerDAO ownerDAO, TableDAO tableDAO){
        this.view = view;
        this.ownerDAO = ownerDAO;
        this.tableDAO = tableDAO;
    }

    public void onRegister() {
        if (view.getEmail().isEmpty() || view.getUsername().isEmpty() || view.getPassword().isEmpty()) {
            view.showEmptyFieldsDetected();
            return;
        }
        if (!RegexUtil.isEmail(view.getEmail())) {
            view.showInvalidEmail();
            return;
        }

        if (ownerDAO.isEmailTaken(view.getEmail())) {
            view.showEmailAlreadyExists();
            return;
        }


        Owner owner = new Owner(view.getUsername(), view.getEmail(), view.getPassword(), Integer.parseInt(view.getTables()));

        ownerDAO.save(owner);

        for (int i = 0; i < owner.getNumberofTables(); i++){
            Table table = new Table(i+1);
            tableDAO.save(table);
        }
        view.onSuccessfulRegister();
    }
}
