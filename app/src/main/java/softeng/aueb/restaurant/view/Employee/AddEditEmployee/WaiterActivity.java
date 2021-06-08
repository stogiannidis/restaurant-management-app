package softeng.aueb.restaurant.view.Employee.AddEditEmployee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

import softeng.aueb.restaurant.MainActivity;
import softeng.aueb.restaurant.databinding.ActivityWaiterBinding;
import softeng.aueb.restaurant.domain.Customer;
import softeng.aueb.restaurant.domain.Employee;
import softeng.aueb.restaurant.domain.Order;
import softeng.aueb.restaurant.ui.login.LoginActivity;
import softeng.aueb.restaurant.util.AndroidUtil;
import softeng.aueb.restaurant.util.recyclerAdapterOrder;
import softeng.aueb.restaurant.view.Employee.EmployeeDetails.OrderManagementActivity;

/**
 * A subclass of {@link AppCompatActivity} used for {@link Employee}
 * in order to verify an {@link Order} as paid
 * @authors team23
 */

public class WaiterActivity extends AppCompatActivity implements WaiterView{

    private RecyclerView recyclerView;
    ActivityWaiterBinding binding;
    WaiterPresenter presenter;
    private ArrayList<Order> unpaidOrders;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWaiterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        recyclerView = binding.unpaidOrders;

        presenter = new WaiterPresenter(MainActivity.memoryInitializer.getOrderDAO(), MainActivity.memoryInitializer.getTableDAO(), this);
        unpaidOrders = presenter.getOrders();

        setAdapter();
        setOnClickListenerVerify();
        setOnCLickListenerLogout();
    }


    private void setAdapter(){
        recyclerAdapterOrder adapter = new recyclerAdapterOrder(unpaidOrders);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setOnClickListenerVerify() {
        binding.confirmationButton.setOnClickListener(v -> presenter.verify());
    }

    private  void setOnCLickListenerLogout(){
        binding.waiterLogoutButton.setOnClickListener(v -> onExit());
    }

    @Override
    public void onSuccessfulVerification() {
        Runnable runnable = () -> {
        };
        AndroidUtil.showDialog(this,
                "Order Paid",
                "Order has been successfully paid",
                "OKAY",
                runnable);
    }

    @Override
    public String getOrderID() {
        return binding.orderToBePaid.getText().toString();
    }

    @Override
    public void setOrderID(String name) {
        binding.orderToBePaid.setText(name);
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
            Intent intent = new Intent(WaiterActivity.this, LoginActivity.class);
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