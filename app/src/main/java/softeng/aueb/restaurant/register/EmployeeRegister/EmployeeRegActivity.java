package softeng.aueb.restaurant.register.EmployeeRegister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import softeng.aueb.restaurant.MainActivity;
import softeng.aueb.restaurant.R;
import softeng.aueb.restaurant.RegisterDesicision;
import softeng.aueb.restaurant.databinding.ActivityEmployeeRegBinding;
import softeng.aueb.restaurant.register.CustomerRegister.CustomerRegActivity;
import softeng.aueb.restaurant.util.AndroidUtil;

public class EmployeeRegActivity extends AppCompatActivity implements  EmployeeRegView{

    ActivityEmployeeRegBinding binding;
    EmployeeRegPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEmployeeRegBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Spinner spinner = binding.spinner2;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(EmployeeRegActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Job_option));

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        presenter = new EmployeeRegPresenter(this,MainActivity.memoryInitializer.getEmployeeDAO());
        setOnClickListener();
    }

    void setOnClickListener(){
        binding.buttonSignUpEmployee.setOnClickListener(v -> presenter.onRegister());
    }

    @Override
    public void onSuccessfulRegister() {
        Runnable runnable = () -> {
            Intent intent = new Intent(EmployeeRegActivity.this, MainActivity.class);
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
        return binding.editTextTextEmailAddressEmployee.getText().toString();
    }

    @Override
    public void setEmail(String email) {
        binding.editTextTextEmailAddressEmployee.setText(email);
    }

    @Override
    public String getUsername() {
        return binding.editTextTextPersonName.getText().toString();
    }

    @Override
    public void setUsername(String username) {
        binding.editTextTextPersonName.setText(username);
    }

    @Override
    public String getPassword() {
        return binding.editTextTextPasswordEmployee.getText().toString();
    }

    @Override
    public void setPassword(String password) {
        binding.editTextTextPasswordEmployee.setText(password);
    }


    @Override
    public String getJob() {
        return binding.spinner2.getSelectedItem().toString();
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