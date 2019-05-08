package www.sumanmyon.com.mpandroiddemoexamples.PiChart;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import www.sumanmyon.com.mpandroiddemoexamples.R;

public class PiChartActivity extends AppCompatActivity {

    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pi_chart);

        //casting
        pieChart = findViewById(R.id.pichart);

        //setting parameters for pie chart
        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);  //sets description to false
        pieChart.setExtraOffsets(5,10,5,5);
        pieChart.setDragDecelerationFrictionCoef(0.95f);  //speed of rotation higher value (1) slow spin
        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(61f);

        //setting entry to make pie chart
        ArrayList<PieEntry> entries = settingEntry();

        //setting PieDataSet
        PieDataSet pieDataSet = new PieDataSet(entries,"Population of different Countries");
        pieDataSet.setSliceSpace(3f);  //spacing in datasets
        pieDataSet.setSelectionShift(5f); //"shifted" away from the center of the chart
        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        //putting PieDataSet to PieData
        PieData pieData = new PieData(pieDataSet);
        pieData.setValueTextSize(12f);
        pieData.setValueTextColor(Color.YELLOW);

        //To make animation
        pieChart.animateY(1000, Easing.EaseInCubic);

        //For description about for pie chart made for
        Description description = new Description();
        description.setText("Population of different Countries.");
        description.setTextSize(8f);
        pieChart.setDescription(description);

        //putting pieData to pie chart
        pieChart.setData(pieData);
    }

    private ArrayList<PieEntry> settingEntry() {
        ArrayList<PieEntry> pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(23f,"USA"));
        pieEntries.add(new PieEntry(43f,"Austria"));
        pieEntries.add(new PieEntry(67f,"India"));
        pieEntries.add(new PieEntry(12f,"Nepal"));
        pieEntries.add(new PieEntry(80f,"China"));

        return pieEntries;
    }
}
