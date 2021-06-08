package softeng.aueb.restaurant.register.CustomerRegister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import softeng.aueb.restaurant.MainActivity;
import softeng.aueb.restaurant.R;
import softeng.aueb.restaurant.databinding.ActivityCustomerRegBinding;
import softeng.aueb.restaurant.databinding.ActivityRegisterDesicisionBinding;
import softeng.aueb.restaurant.ui.login.LoginActivity;
import softeng.aueb.restaurant.util.AndroidUtil;
import softeng.aueb.restaurant.view.Customer.AddOrder.AddOrderActivity;

public class CustomerRegActivity extends AppCompatActivity implements CustomerRegView {
    CustomerRegPresenter presenter;
    ActivityCustomerRegBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCustomerRegBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        presenter = new CustomerRegPresenter(this,MainActivity.memoryInitializer.getCustomerDAO());
        setClickListeners();
    }

    private void setClickListeners(){
        binding.buttonSignUpCustomer.setOnClickListener(v -> presenter.onRegister());
    }

    @Override
    public void onSuccessfulRegister() {
        Runnable runnable = () -> {
            Intent intent = new Intent(CustomerRegActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        };
        AndroidUtil.showDialog(this,
                "Register successfully",
                "Congratulations " + getUsername() + ",\nYou can now use the app",
                "OKAY",
                runnable);
    }

    @Override
    public String getEmail() {
        return binding.editTextTextEmailAddressCustomer.getText().toString();
    }

    @Override
    public void setEmail(String email) {
        binding.editTextTextEmailAddressCustomer.setText(email);
    }

    @Override
    public String getUsername() {
        return binding.editTextTextPersonNameCustomer.getText().toString();
    }

    @Override
    public void setUsername(String username) {
        binding.editTextTextPersonNameCustomer.setText(username);
    }

    @Override
    public String getPassword() {
        return binding.editTextTextPasswordCustomer.getText().toString();
    }

    @Override
    public void setPassword(String password) {
        binding.editTextTextPasswordCustomer.setText(password);
    }

    @Override
    public void showEmptyFieldsDetected() {
        Runnable runnable = () -> {

        };
        AndroidUtil.showDialog(this,
                "Register failed",
                "Empty fields detected. \nFill them to register..",
                "OKAY",
                runnable);
    }

    @Override
    public void showEmailAlreadyExists() {
        Runnable runnable = () -> {

        };
        AndroidUtil.showDialog(this,
                "Register failed",
                "Email is taken. In case of forgetting your password contact with our team",
                "OKAY",
                runnable);
    }

    @Override
    public void showInvalidEmail() {
        Runnable runnable = () -> {

        };
        AndroidUtil.showDialog(this,
                "Invalid Email",
                "Invalid email detected. Please use your email",
                "OKAY",
                runnable);
    }
}