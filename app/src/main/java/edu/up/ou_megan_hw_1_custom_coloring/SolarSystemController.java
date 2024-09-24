package edu.up.ou_megan_hw_1_custom_coloring;

import android.widget.SeekBar;
import android.widget.TextView;

public class SolarSystemController implements SeekBar.OnSeekBarChangeListener {
    private SolarSystemCanvas sSCanvas;
    private TextView tvRVal;
    private TextView tvGVal;
    private TextView tvBVal;
    private SeekBar sbRed;
    private SeekBar sbGreen;
    private SeekBar sbBlue;

    public SolarSystemController(TextView initRVal, TextView initGVal, TextView initBVal,
                                 SeekBar initSbRed, SeekBar initSbGreen, SeekBar initSbBlue,
                                 SolarSystemCanvas initCanvas) {
        tvRVal = initRVal;
        tvGVal = initGVal;
        tvBVal = initBVal;
        sbRed = initSbRed;
        sbGreen = initSbGreen;
        sbBlue = initSbBlue;

        sSCanvas = initCanvas;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int sbVal, boolean b) {
        if (seekBar.equals(sbRed)) {
            tvRVal.setText("" + sbVal);
        }
        else if (seekBar.equals(sbGreen)) {
            tvGVal.setText("" + sbVal);
        }
        else if (seekBar.equals(sbBlue)){
            tvBVal.setText("" + sbVal);
        }

        sSCanvas.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) { }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) { }
}
