package softeng.aueb.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import softeng.aueb.restaurant.domain.Customer;
import softeng.aueb.restaurant.domain.Employee;
import softeng.aueb.restaurant.domain.Owner;
import softeng.aueb.restaurant.register.CustomerRegister.CustomerRegActivity;
import softeng.aueb.restaurant.register.EmployeeRegister.EmployeeRegActivity;
import softeng.aueb.restaurant.register.OwnerRegister.OwnerRegActivity;

/**
 * A subclass of {@link AppCompatActivity} used for {@link Customer} {@link Owner} {@link Employee}
 * to choose the register option
 */
public class RegisterDesicision extends AppCompatActivity {
    private Spinner spinner;
    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_desicision);

        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(RegisterDesicision.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Registration_option));

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        buttonRegister = findViewById(R.id.choice);
        buttonRegister.setOnClickListener(v -> {
            String spinnerValue = spinner.getSelectedItem().toString();
            switch (spinnerValue) {
                case "Customer": {
                    Intent intent = new Intent(RegisterDesicision.this, CustomerRegActivity.class);
                    startActivity(intent);
                    break;
                }
                case "Owner": {
                    Intent intent = new Intent(RegisterDesicision.this, OwnerRegActivity.class);
                    startActivity(intent);
                    break;
                }
                case "Employee": {
                    Intent intent = new Intent(RegisterDesicision.this, EmployeeRegActivity.class);
                    startActivity(intent);
                    break;
                }
                default:
                    throw new IllegalArgumentException("Please select a value");
            }
        });
    }
}