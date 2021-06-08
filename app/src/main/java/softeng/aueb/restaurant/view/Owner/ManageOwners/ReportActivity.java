package softeng.aueb.restaurant.view.Owner.ManageOwners;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import softeng.aueb.restaurant.MainActivity;
import softeng.aueb.restaurant.databinding.ActivityReportBinding;
import softeng.aueb.restaurant.domain.Employee;
import softeng.aueb.restaurant.domain.Order;
import softeng.aueb.restaurant.domain.Owner;
import softeng.aueb.restaurant.util.AndroidUtil;
import softeng.aueb.restaurant.view.Owner.OwnerDetails.AddMenuActivity;
/**
 * A subclass of {@link AppCompatActivity} used for {@link Owner}
 * in order to get the revenue from all {@link Order}
 * @authors team23
 */
public class ReportActivity extends AppCompatActivity implements ReportView {

    ActivityReportBinding binding;
    ReportPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityReportBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        presenter = new ReportPresenter(MainActivity.memoryInitializer.getTableDAO(), MainActivity.memoryInitializer.getProductItemDAO(),this);

        setOnClickListenerRevenue();
        setOnClickListenerBack();
    }

    private void  setOnClickListenerRevenue(){
        binding.calculateRevenue.setOnClickListener(v -> presenter.calculateRevenue());
    }

    private void setOnClickListenerBack(){
        binding.backButtonOwner.setOnClickListener(v -> onExit());
    }

    @Override
    public  void onExit(){
        Runnable runnable = () ->{
            Intent intent = new Intent(ReportActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        };
        AndroidUtil.showDialog(this,
                "GoodBye Sir",
                "Have a nice day!",
                "OKAY",
                runnable);
        }

    @Override
    public void onRevenueCalculation(double revenue) {
        Runnable runnable = ()->{
        };
        AndroidUtil.showDialog(this,
                "Revenue calculated Sir",
                "Your total revenue is: " + revenue,
                "OKAY",
                runnable);
    }
}