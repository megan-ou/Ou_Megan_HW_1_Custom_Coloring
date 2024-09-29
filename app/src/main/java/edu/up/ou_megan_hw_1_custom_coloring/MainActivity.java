package edu.up.ou_megan_hw_1_custom_coloring;

/**
 * Calls canvas and controller class to draw an image of a solar system
 *
 * @Author: Megan Ou
 * @Date: 09/26/24
 */

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import edu.up.myapplication.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create references to objects in layout

        TextView tvRedVal = findViewById(R.id.tvRedVal);
        TextView tvGreenVal = findViewById(R.id.tvGreenVal);
        TextView tvBlueVal = findViewById(R.id.tvBlueVal);
        TextView tvCurrentElement = findViewById(R.id.tvCurrentElement);

        SeekBar sbRed = findViewById(R.id.sbRed);
        SeekBar sbGreen = findViewById(R.id.sbGreen);
        SeekBar sbBlue = findViewById(R.id.sbBlue);

        SolarSystemCanvas sSC = findViewById(R.id.solarSystemCanvas);

        //create instance of controller class
        SolarSystemController controller = new SolarSystemController(tvRedVal, tvGreenVal, tvBlueVal,
                tvCurrentElement, sbRed, sbGreen, sbBlue, sSC);

        //assign listener to objects
        sbRed.setOnSeekBarChangeListener(controller);
        sbGreen.setOnSeekBarChangeListener(controller);
        sbBlue.setOnSeekBarChangeListener(controller);

        sSC.setOnTouchListener(controller);
    }
}