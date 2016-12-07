package id.sch.smktelkom_mlg.project.xiirpl305152535.mokletvoterapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        Intent intent = new Intent(this, IntroActivity.class);
        startActivity(intent);

        findViewById(R.id.buttonUser).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // startActivity(new Intent(HomeScreen, ));
            }
        });

        findViewById(R.id.buttonAdmin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeScreen.this, MainActivity.class));
            }
        });
    }
}
