package softeng.aueb.restaurant.view.Customer.AddOrder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

import softeng.aueb.restaurant.MainActivity;
import softeng.aueb.restaurant.databinding.ActivityAddOrderBinding;
import softeng.aueb.restaurant.domain.Customer;
import softeng.aueb.restaurant.domain.Order;
import softeng.aueb.restaurant.domain.ProductItem;
import softeng.aueb.restaurant.ui.login.LoginActivity;
import softeng.aueb.restaurant.util.AndroidUtil;
import softeng.aueb.restaurant.util.recyclerAdapter;

/**
 * A subclass of {@link AppCompatActivity} used for {@link Customer}
 * in order to create an {@link Order}
 * @authors team23
 */
public class AddOrderActivity extends AppCompatActivity implements AddOrderView {

    private RecyclerView recyclerView;
    AddOrderPresenter presenter;
    private ArrayList<ProductItem> menu;
    ActivityAddOrderBinding binding;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        recyclerView = binding.recyclerView;
        username = getIntent().getStringExtra("customer");

        presenter = new AddOrderPresenter(username, MainActivity.memoryInitializer.getProductItemDAO(),
                MainActivity.memoryInitializer.getOrderDAO(),MainActivity.memoryInitializer.getTableDAO(),this);
        menu = (ArrayList<ProductItem>) presenter.setMenuInfo();
        setAdapter();
        setOnClickListenerAdd();
        setOnCLickListenerCancel();
        setOnClickListenerConfirm();
    }

    private void setOnClickListenerAdd(){
        binding.buttonAdd.setOnClickListener(v -> presenter.onOrderCreation());
    }

    private void setOnClickListenerConfirm(){
        binding.buttonOrder.setOnClickListener(v -> presenter.onOrderConfirmation());
    }

    private void setOnCLickListenerCancel(){
        binding.buttonClear.setOnClickListener(v-> presenter.clearBasket());
    }

    private void setAdapter(){
        recyclerAdapter adapter = new recyclerAdapter(menu);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onSuccessfulAddition() {
        Runnable runnable = () -> {
        };
        AndroidUtil.showDialog(this,
                "Item Added",
                "Item has been added successfully to your basket!",
                "OKAY",
                runnable);
    }

    @Override
    public String getName() {
        return binding.itemToOrder.getText().toString();
    }

    @Override
    public void setName(String name) {
        binding.itemToOrder.setText(name);
    }


    @Override
    public String getQuantity() {
        return binding.itemToOrderQuantity.getText().toString();
    }

    @Override
    public void setQuantity(String quantity) {
        binding.itemToOrderQuantity.setText(quantity);
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
    public void showInvalidProduct() {
        Runnable runnable = () -> {
        };
        AndroidUtil.showDialog(this,
                "Invalid Product",
                "Invalid product detected. Please try again",
                "OKAY",
                runnable);
    }
    @Override
    public void showInvalidQuantity() {
        Runnable runnable = () -> {
        };
        AndroidUtil.showDialog(this,
                "Invalid Quantity",
                "Cannot produce this amount of food",
                "OKAY",
                runnable);
    }


    @Override
    public void onExit(int orderNumber) {
        Runnable runnable = () ->{
            Intent intent = new Intent(AddOrderActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        };
        AndroidUtil.showDialog(this,
                "Order"+"#"+orderNumber+ "Created",
                "Your order is ready to go!",
                "OKAY",
                runnable);
    }

    @Override
    public void setTable(String number) {
        binding.tableNumber.setText(number);
    }

    @Override
    public String getTable() {
        return binding.tableNumber.getText().toString();
    }

    @Override
    public void showInvalidTable() {
        Runnable runnable= this::finish;
        AndroidUtil.showDialog(this,
                "Invalid table number",
                "Please choose a valid table number",
                "OKAY",runnable);
    }

    @Override
    public void onBasketClear() {
        Runnable runnable = () ->{
        };
        AndroidUtil.showDialog(this,"Basket Cleared",
                "Your basket has been cleared successfully",
                "OKAY",runnable);
    }

}