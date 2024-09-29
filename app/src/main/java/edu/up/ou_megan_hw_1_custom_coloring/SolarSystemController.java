package edu.up.ou_megan_hw_1_custom_coloring;

/**
 * Controller class that handles touch and seekbar events. Used to change textViews, set
 * seekbar progress and update color components of PlanetElements drawn on the canvas.
 *
 * @author Megan Ou
 * @date 09/26/24
 */

import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class SolarSystemController implements SeekBar.OnSeekBarChangeListener, View.OnTouchListener {
    private SolarSystemCanvas sSCanvas;
    private PlanetElement selectedPlanet;
    private TextView tvRVal;
    private TextView tvGVal;
    private TextView tvBVal;
    private TextView tvCurrentElement;
    private SeekBar sbRed;
    private SeekBar sbGreen;
    private SeekBar sbBlue;
    private float xVal;
    private float yVal;
    private Paint currPaint;
    private int rValInt;
    private int gValInt;
    private int bValInt;
    private ArrayList<PlanetElement> allPlanets;
    private float planetRadius;

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
        rValInt = 0;
        gValInt = 0;
        bValInt = 0;
        selectedPlanet = null;
        currPaint = null;

        allPlanets = sSCanvas.getAllPlanets();
    }

    /**
     * Method that tracks changes to seekBar and updates a textView with the value
     * Also used to update paint component if a planet is selected.
     *
     * @param seekBar what seekbar is being edited
     * @param sbVal current value/progress change of seekBar
     * @param b unused
     */
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

        //Edit colors of selected PlanetElement if SeekBar is moved
        if (selectedPlanet != null) {
            //get current RGB values
            extractRGB();

            //update with new RGB Values
            if (seekBar.equals(sbRed)) {
                rValInt = sbVal;
            }
            else if (seekBar.equals(sbGreen)) {
                gValInt = sbVal;
            }
            else if (seekBar.equals(sbBlue)) {
                bValInt = sbVal;
            }

            //pass all color components into one int
            int newColor = Color.argb(0xFF,rValInt,gValInt,bValInt);

            //set new color
            selectedPlanet.setPlanetColor(newColor);
        }

        //Redraw canvas
        sSCanvas.invalidate();
    }

    /**
     * Method that identifies if a touch event occurs within the area of a planet element
     * If planet was selected, it updates the seekBars to display current planet RGB value
     * and a TextView with planet name
     *
     * @param view unused
     * @param motionEvent what was touched on the screen
     * @return true
     */
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        xVal = motionEvent.getX();
        yVal = motionEvent.getY();

        //iterate through ArrayList and check to see if touch event occurs within each planet
        //if touch event occurs within an element, assign element to selectedPlanet
        for (int i = 0; i < allPlanets.size(); i++) {
            planetRadius = allPlanets.get(i).getPlanetRadius();
            if (allPlanets.get(i).inElement(xVal,yVal,planetRadius)) {
                selectedPlanet = allPlanets.get(i);
            }
        }

        //If selectedPlanet is not null, update current element TextView with Planet name
        //Update seekbars with element's RGB value using helper method to extract RGB values
        if (selectedPlanet != null) {
            tvCurrentElement.setText(selectedPlanet.getPlanetName());

            extractRGB();
            sbRed.setProgress(rValInt);
            sbGreen.setProgress(gValInt);
            sbBlue.setProgress(bValInt);
        }
        return true;
    }

    /**
     * Helper method to extract RGB value of current planet
     *
     * External Citation 09/26/24
     * Problem: How to extract just red, green, and blue components
     * Solution: Use Color.red/green/blue
     * Source: Landon Harrison (talked about it in class)
     */
    public void extractRGB() {
        //get current paint
        currPaint = selectedPlanet.getPlanetColor();
        int currPaintInt = currPaint.getColor();
        //extract RGB
        rValInt = Color.red(currPaintInt);
        gValInt = Color.green(currPaintInt);
        bValInt = Color.blue(currPaintInt);
    }

    //empty class
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) { }

    //empty class
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) { }

}

