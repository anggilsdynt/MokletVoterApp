package id.sch.smktelkom_mlg.project.xiirpl305152535.mokletvoterapp.pasha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import id.sch.smktelkom_mlg.project.xiirpl305152535.mokletvoterapp.R;

public class MenuAdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_admin);

        findViewById(R.id.buttonDashboard).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuAdminActivity.this, PeriodeTahunActivity.class));
            }
        });

    }
}
