package softeng.aueb.restaurant.view.Employee.EmployeeDetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

import softeng.aueb.restaurant.MainActivity;
import softeng.aueb.restaurant.databinding.ActivityOrderManagementBinding;
import softeng.aueb.restaurant.domain.Employee;
import softeng.aueb.restaurant.domain.Order;
import softeng.aueb.restaurant.domain.ProductItem;
import softeng.aueb.restaurant.ui.login.LoginActivity;
import softeng.aueb.restaurant.util.AndroidUtil;
import softeng.aueb.restaurant.util.recyclerAdapter;
import softeng.aueb.restaurant.util.recyclerAdapterOrder;
import softeng.aueb.restaurant.view.Customer.AddOrder.AddOrderActivity;
import softeng.aueb.restaurant.view.Customer.AddOrder.AddOrderPresenter;

/**
 * A subclass of {@link AppCompatActivity} used for {@link Employee}
 * in order to verify an {@link Order} as verified
 * @authors team23
 */

public class OrderManagementActivity extends AppCompatActivity implements OrderManagementView{

    private RecyclerView recyclerView;
    OrderManagementPresenter presenter;
    private ArrayList<Order> unverifiedOrders;
    ActivityOrderManagementBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderManagementBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        recyclerView = binding.ordersToVerify;

        presenter = new OrderManagementPresenter(MainActivity.memoryInitializer.getOrderDAO(),this);

        unverifiedOrders = presenter.getOrder();
        setAdapter();
        setOnClickListenerVerify();
        setOnClickListenerLogout();

    }

    private void setAdapter(){
        recyclerAdapterOrder adapter = new recyclerAdapterOrder(unverifiedOrders);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setOnClickListenerVerify() {
        binding.verificationButton.setOnClickListener(v -> presenter.verify());
    }

    private void setOnClickListenerLogout() {
        binding.logoutButton.setOnClickListener(v -> onExit());
    }

    @Override
    public void onSuccessfulVerification() {
        Runnable runnable = () -> {
        };
        AndroidUtil.showDialog(this,
                "Order Verified",
                "You have successfully verified the Order",
                "OKAY",
                runnable);
    }

    @Override
    public String getOrderID() {
        return binding.orderIdToVerify.getText().toString();
    }

    @Override
    public void setOrderID(String name) {
        binding.orderIdToVerify.setText(name);
    }

    @Override
    public String getPrepationTime() {
        return binding.PREPARATIONTIME.getText().toString();
    }

    @Override
    public void setPreparationTime(String preparationTime) {
        binding.PREPARATIONTIME.setText(preparationTime);
    }

    @Override
    public void showEmptyFieldsDetected() {
        Runnable runnable = () -> {
        };
        AndroidUtil.showDialog(this,
                "Addition failed",
                "Empty fields detected. \nFill them to add the product..",
                "OKAY",
                runnable);
    }

    @Override
    public void showInvalidOrder() {
        Runnable runnable = () -> {
        };
        AndroidUtil.showDialog(this,
                "No such Order",
                "There is no order. \nwith that ID..",
                "OKAY",
                runnable);
    }

    @Override
    public void onExit() {
        Runnable runnable = () ->{
            Intent intent = new Intent(OrderManagementActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        };
        AndroidUtil.showDialog(this,
                "You logged out",
                "GoodBye",
                "OKAY",
                runnable);
    }
}