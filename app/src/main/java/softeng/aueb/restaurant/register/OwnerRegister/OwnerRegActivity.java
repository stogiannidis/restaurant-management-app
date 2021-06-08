package softeng.aueb.restaurant.register.OwnerRegister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import softeng.aueb.restaurant.MainActivity;
import softeng.aueb.restaurant.R;
import softeng.aueb.restaurant.databinding.ActivityOwnerRegBinding;
import softeng.aueb.restaurant.register.CustomerRegister.CustomerRegActivity;
import softeng.aueb.restaurant.util.AndroidUtil;
import softeng.aueb.restaurant.view.Owner.OwnerDetails.AddMenuActivity;

public class OwnerRegActivity extends AppCompatActivity implements OwnerRegView{

    OwnerRegPresenter presenter;
    ActivityOwnerRegBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOwnerRegBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        presenter = new OwnerRegPresenter(this,MainActivity.memoryInitializer.getOwnerDAO(),MainActivity.memoryInitializer.getTableDAO());
        setOnClickListener();
    }

    public void setOnClickListener(){
        binding.buttonSignUpOwner.setOnClickListener(v -> presenter.onRegister());
    }

    @Override
    public void onSuccessfulRegister() {
        Runnable runnable = () -> {
            Intent intent = new Intent(OwnerRegActivity.this, AddMenuActivity.class);
            startActivity(intent);
            finish();
        };
        AndroidUtil.showDialog(this,
                "Register successfully",
                "Welcome " + getUsername() + ",\nYou can now use the app",
                "OKAY",
                runnable);
    }

    @Override
    public String getEmail() {
        return binding.editTextTextEmailAddressOwner.getText().toString();
    }

    @Override
    public void setEmail(String email) {
        binding.editTextTextEmailAddressOwner.setText(email);
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
        return binding.editTextTextPasswordOwner.getText().toString();
    }

    @Override
    public void setPassword(String password) {
        binding.editTextTextPasswordOwner.setText(password);
    }

    @Override
    public void setTables(String numberOfTables) {
        binding.editTextNumber.setText(numberOfTables);
    }

    @Override
    public String getTables() {
        return binding.editTextNumber.getText().toString();
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