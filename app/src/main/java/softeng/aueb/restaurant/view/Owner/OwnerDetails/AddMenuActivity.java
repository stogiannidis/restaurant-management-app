package softeng.aueb.restaurant.view.Owner.OwnerDetails;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import softeng.aueb.restaurant.MainActivity;
import softeng.aueb.restaurant.databinding.ActivityAddMenuBinding;
import softeng.aueb.restaurant.domain.Order;
import softeng.aueb.restaurant.domain.Owner;
import softeng.aueb.restaurant.domain.ProductItem;
import softeng.aueb.restaurant.register.OwnerRegister.OwnerRegActivity;
import softeng.aueb.restaurant.util.AndroidUtil;

/**
 * A subclass of {@link AppCompatActivity} used for {@link Owner}
 * in order to create the menu consisting of  {@link ProductItem}
 * @authors team23
 */

public class AddMenuActivity extends AppCompatActivity implements AddMenuView {

    ActivityAddMenuBinding binding;
    AddMenuPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        presenter = new AddMenuPresenter(MainActivity.memoryInitializer.getProductItemDAO(),this);

        setOnClickListenerAdd();

        setOnClickListenerExit();
    }

    void setOnClickListenerAdd(){
        binding.Add.setOnClickListener(v -> {
            presenter.onAddition();;
        });

    }

    void setOnClickListenerExit(){
        binding.exit.setOnClickListener(v -> onExit());
    }

    @Override
    public void onSuccessfulAddition() {
        Runnable runnable = () -> {
        };
        AndroidUtil.showDialog(this,
                "Item Added",
                "Item has been added successfully!",
                "OKAY",
                runnable);
    }
    @Override
    public  void onExit(){
        Runnable runnable = () ->{
            Intent intent = new Intent(AddMenuActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        };
        AndroidUtil.showDialog(this,
                "Menu Created",
                "Your restaurant is ready to go!",
                "OKAY",
                runnable);
    }

    @Override
    public String getName() {
        return binding.itemName.getText().toString();
    }

    @Override
    public void setName(String name) {
        binding.itemName.setText(name);
    }

    @Override
    public String getPrice() {
        return binding.itemPrice.getText().toString();
    }

    @Override
    public void setPrice(String price) {
        binding.itemPrice.setText(price);
    }

    @Override
    public String getQuantity() {
        return binding.itemQuantity.getText().toString();
    }

    @Override
    public void setQuantity(String quantity) {
        binding.itemQuantity.setText(quantity);
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
    public void showProductAlreadyExists() {
        Runnable runnable = () -> {
        };
        AndroidUtil.showDialog(this,
                "Product already in the menu",
                "The product you tried to add has been already added in your menu" +
                        " \n Be careful",
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
}