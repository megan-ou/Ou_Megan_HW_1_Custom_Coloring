/**
 * @author Megan Ou
 */
package edu.up.ou_megan_hw_1_custom_coloring;

import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class SolarSystemController implements SeekBar.OnSeekBarChangeListener, View.OnTouchListener {
    private SolarSystemCanvas sSCanvas;
    private TextView tvRVal;
    private TextView tvGVal;
    private TextView tvBVal;
    private TextView tvCurrentElement;
    private SeekBar sbRed;
    private SeekBar sbGreen;
    private SeekBar sbBlue;
    private float xVal;
    private float yVal;

    public SolarSystemController(TextView initRVal, TextView initGVal, TextView initBVal, TextView initCurrElement,
                                 SeekBar initSbRed, SeekBar initSbGreen, SeekBar initSbBlue,
                                 SolarSystemCanvas initCanvas) {
        tvRVal = initRVal;
        tvGVal = initGVal;
        tvBVal = initBVal;
        tvCurrentElement = initCurrElement;
        sbRed = initSbRed;
        sbGreen = initSbGreen;
        sbBlue = initSbBlue;

        sSCanvas = initCanvas;

        xVal = 0;
        yVal = 0;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int sbVal, boolean b) {
        //update textview with RGB values
        if (seekBar.equals(sbRed)) {
            tvRVal.setText("" + sbVal);
        }
        else if (seekBar.equals(sbGreen)) {
            tvGVal.setText("" + sbVal);
        }
        else if (seekBar.equals(sbBlue)){
            tvBVal.setText("" + sbVal);
        }

        //redraw canvas
        sSCanvas.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) { }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) { }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        xVal = motionEvent.getX();
        yVal = motionEvent.getY();


        return true;
    }

}
