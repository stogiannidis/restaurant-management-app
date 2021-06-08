package softeng.aueb.restaurant.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import softeng.aueb.restaurant.MainActivity;
import softeng.aueb.restaurant.databinding.ActivityLoginBinding;
import softeng.aueb.restaurant.util.AndroidUtil;
import softeng.aueb.restaurant.view.Customer.Options.OptionsActivity;
import softeng.aueb.restaurant.view.Employee.AddEditEmployee.WaiterActivity;
import softeng.aueb.restaurant.view.Employee.EmployeeDetails.OrderManagementActivity;
import softeng.aueb.restaurant.view.Owner.ManageOwners.ReportActivity;

public class LoginActivity extends AppCompatActivity implements LoginView{

    ActivityLoginBinding binding;
    LoginPresenter presenter;

    EditText loginUsername;
    EditText loginPassword;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loginUsername = binding.username;
        loginPassword = binding.password;

        loginButton = binding.login;

        presenter = new LoginPresenter(this, MainActivity.memoryInitializer.getCustomerDAO(),
                MainActivity.memoryInitializer.getOwnerDAO(),MainActivity.memoryInitializer.getEmployeeDAO());

        loginButton.setOnClickListener(v -> presenter.onLogin());
    }

    @Override
    public String getUsername() {
        return binding.username.getText().toString();
    }

    @Override
    public void setUsername(String username) {
        binding.username.setText(username);
    }

    @Override
    public String getPassword() {
        return binding.password.getText().toString();
    }

    @Override
    public void setPassword(String password) {
        binding.password.setText(password);
    }

    @Override
    public void showEmptyFieldsDetected() {
        Runnable runnable = () -> {
        };
        AndroidUtil.showDialog(this,
                "Empty fields",
                "Please insert email and password to login",
                "OKAY",
                runnable);
    }

    @Override
    public void showFailedLogin() {
        Runnable runnable = () -> {
        };
        AndroidUtil.showDialog(this,
                "Couldn't login",
                "Wrong username or password." + getUsername() + " \nPlease try again",
                "OKAY",
                runnable);
    }

    @Override
    public void showSuccessCustomerLogin() {
        Runnable runnable = () -> {
            Intent intent = new Intent(LoginActivity.this, OptionsActivity.class);
            intent.putExtra("customer",loginUsername.getText().toString());
            startActivity(intent);
            finish();
        };
        AndroidUtil.showDialog(this,
                "Successful login",
                "Welcome back "+ getUsername(),
                "Proceed",
                runnable);
    }

    @Override
    public void showSuccessOwnerLogin() {
        Runnable runnable = () -> {
            startActivity(new Intent(LoginActivity.this, ReportActivity.class));
            finish();
        };
        AndroidUtil.showDialog(this,
                "Successful login",
                "Welcome back Afentiko",
                "Proceed",
                runnable);
    }
    @Override
    public void showSuccessEmployeeLogin(String job){
        Runnable runnable = () -> {
            if (job.equals("Chef"))
                startActivity(new Intent(LoginActivity.this, OrderManagementActivity.class));
            if(job.equals("Waiter"))
                startActivity(new Intent(LoginActivity.this, WaiterActivity.class));
            finish();
        };
        AndroidUtil.showDialog(this,
                "Successful login",
                "Have a nice shift",
                "Cry",
                runnable);
    }

    @Override
    public void showInvalidEmail() {
        Runnable runnable = () -> {
        };
        AndroidUtil.showDialog(this,
                "Invalid email",
                "Email is not valid",
                "OKAY",
                runnable);
    }
}