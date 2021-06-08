package softeng.aueb.restaurant.view.Customer.Options;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import softeng.aueb.restaurant.R;
import softeng.aueb.restaurant.RegisterDesicision;
import softeng.aueb.restaurant.databinding.ActivityOptionsBinding;
import softeng.aueb.restaurant.domain.Customer;
import softeng.aueb.restaurant.domain.Order;
import softeng.aueb.restaurant.register.CustomerRegister.CustomerRegActivity;
import softeng.aueb.restaurant.register.EmployeeRegister.EmployeeRegActivity;
import softeng.aueb.restaurant.register.OwnerRegister.OwnerRegActivity;
import softeng.aueb.restaurant.view.Customer.AddOrder.AddOrderActivity;
import softeng.aueb.restaurant.view.Customer.ViewOrder.ViewOrderStatusActivity;


/**
 * A subclass of {@link AppCompatActivity} used for {@link Customer}
 * in order to view an {@link Order} status or request to pay
 * @authors team23
 */

public class OptionsActivity extends AppCompatActivity {

    ActivityOptionsBinding binding;
    Spinner spinner;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOptionsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        username = getIntent().getStringExtra("customer");
        spinner = binding.spinnerOption;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(OptionsActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.customer_option));

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        setOnClickListener();
    }

    private void setOnClickListener(){
        binding.option.setOnClickListener(v -> {
            String spinnerValue = spinner.getSelectedItem().toString();
            switch (spinnerValue) {
                case "Create order": {
                    Intent intent = new Intent(OptionsActivity.this, AddOrderActivity.class);
                    intent.putExtra("customer",username);
                    startActivity(intent);
                    break;
                }
                case "View order": {
                    Intent intent = new Intent(OptionsActivity.this, ViewOrderStatusActivity.class);
                    intent.putExtra("customer",username);
                    startActivity(intent);
                    break;
                }
                default:
                    throw new IllegalArgumentException("Please select a value");
            }
        });
    }
}