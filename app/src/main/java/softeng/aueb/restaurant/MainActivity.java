package softeng.aueb.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import softeng.aueb.restaurant.dao.memorydao.MemoryInitializer;
import softeng.aueb.restaurant.ui.login.LoginActivity;

/**
 * Main Screen of our apps
 * @authors team23
 */
public class MainActivity extends AppCompatActivity {

    public static MemoryInitializer memoryInitializer;
    public static Context appContext;
    private Button buttonLogin;
    private Button buttonSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        memoryInitializer = new MemoryInitializer();
        memoryInitializer.prepareData();

        appContext = getApplicationContext();

        buttonLogin = findViewById(R.id.buttonLogIn);
        buttonSignUp = findViewById(R.id.buttonSignUp);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterDesicision.class);
                startActivity(intent);
            }
        });
    }
}