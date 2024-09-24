package edu.up.ou_megan_hw_1_custom_coloring;

import android.widget.SeekBar;
import android.widget.TextView;

public class SolarSystemController implements SeekBar.OnSeekBarChangeListener {
    private TextView tvRVal;
    private TextView tvGVal;
    private TextView tvBVal;
    private SeekBar sbRed;
    private SeekBar sbGreen;
    private SeekBar sbBlue;

    public SolarSystemController(TextView initRVal, TextView initGVal, TextView initBVal,
                                 SeekBar initSbRed, SeekBar initSbGreen, SeekBar initSbBlue) {
        tvRVal = initRVal;
        tvGVal = initGVal;
        tvBVal = initBVal;
        sbRed = initSbRed;
        sbGreen = initSbGreen;
        sbBlue = initSbBlue;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) { }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) { }
}
