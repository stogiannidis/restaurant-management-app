package softeng.aueb.restaurant.view.Customer.ViewOrder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;


import softeng.aueb.restaurant.MainActivity;
import softeng.aueb.restaurant.databinding.ActivityViewOrderStatusBinding;
import softeng.aueb.restaurant.domain.Customer;
import softeng.aueb.restaurant.domain.Order;
import softeng.aueb.restaurant.ui.login.LoginActivity;
import softeng.aueb.restaurant.util.AndroidUtil;
import softeng.aueb.restaurant.view.Customer.Options.OptionsActivity;
/**
 * A subclass of {@link AppCompatActivity} used for {@link Customer}
 * in order to view an {@link Order} status
 * @authors team23
 */
public class ViewOrderStatusActivity extends AppCompatActivity implements ViewOrderStatusView {

    ViewOrderStatusPresenter presenter;
    ActivityViewOrderStatusBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewOrderStatusBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String username = getIntent().getStringExtra("customer");
        presenter = new ViewOrderStatusPresenter(username, MainActivity.memoryInitializer.getCustomerDAO(),
                MainActivity.memoryInitializer.getOrderDAO(),this);
        presenter.projectOrderStatus();

        setOnClickListenerBack();

        setOnCLickListenerPay();

        setOnClickListenerLogOut();
    }

    void setOnCLickListenerPay(){
        binding.payButton.setOnClickListener(v -> presenter.payOrder());
    }

    void setOnClickListenerBack(){
        binding.backButton.setOnClickListener(v -> {
            startActivity(new Intent(ViewOrderStatusActivity.this, OptionsActivity.class));
        });
    }
    void setOnClickListenerLogOut(){
        binding.buttonLogoutC.setOnClickListener(v -> {
            startActivity(new Intent(ViewOrderStatusActivity.this, LoginActivity.class));
        });
    }

    @Override
    public void setTime(String time) {
        binding.TIME.setText(time);
    }

    @Override
    public String getTime() {
        return binding.TIME.getText().toString();
    }

    @Override
    public void setOrderID(String id) {
        binding.viewOrderID.setText(id);
    }

    @Override
    public String getOrderID() {
        return binding.viewOrderID.getText().toString();
    }

    @Override
    public void setPrice(String price) {
        binding.MONEY.setText(price);
    }

    @Override
    public String getPrice() {
        return binding.MONEY.getText().toString();
    }

    @Override
    public void OnPayment() {
        Runnable runnable = () -> {
        };
        AndroidUtil.showDialog(this,
                "Employee notified",
                "An employee got your request",
                "OKAY",
                runnable);
    }
}