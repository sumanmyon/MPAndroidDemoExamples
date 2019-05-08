package www.sumanmyon.com.mpandroiddemoexamples;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import www.sumanmyon.com.mpandroiddemoexamples.PiChart.PiChartActivity;

public class MainActivity extends AppCompatActivity {

    Button pieChartButton;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pieChartButton = findViewById(R.id.button_piechart);

        pieChartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                activity = new PiChartActivity();
//                startIntent();
                Intent i = new Intent(MainActivity.this,PiChartActivity.class);
                startActivity(i);
            }
        });
    }

    private void startIntent() {
        Intent i = new Intent(MainActivity.this,activity.getClass());
        startActivity(i);
    }
}
