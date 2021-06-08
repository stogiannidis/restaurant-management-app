package softeng.aueb.restaurant.register.EmployeeRegister;


import softeng.aueb.restaurant.dao.daoInf.EmployeeDAO;
import softeng.aueb.restaurant.domain.Employee;
import softeng.aueb.restaurant.util.RegexUtil;

public class EmployeeRegPresenter {
    EmployeeRegView view;
    EmployeeDAO employeeDAO;

    public EmployeeRegPresenter(EmployeeRegView view, EmployeeDAO employeeDAO){
        this.view = view;
        this.employeeDAO = employeeDAO;
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

        if (employeeDAO.IsEmailTaken(view.getEmail())) {
            view.showEmailAlreadyExists();
            return;
        }


        Employee employee = new Employee(view.getEmail(), view.getPassword(), view.getUsername(), view.getJob());

        employeeDAO.save(employee);

        view.onSuccessfulRegister();
    }
}
