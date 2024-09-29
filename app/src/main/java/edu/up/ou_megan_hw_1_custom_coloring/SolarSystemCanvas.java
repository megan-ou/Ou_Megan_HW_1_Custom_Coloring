package edu.up.ou_megan_hw_1_custom_coloring;

/**
 * Canvas class that calls the PlanetElement class to create planet objects, place them in
 * an array, and draw the elements on a canvas.
 *
 * @Author: Megan Ou
 * @Date: 09/26/24
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

import java.util.ArrayList;

import edu.up.myapplication.R;

public class SolarSystemCanvas extends SurfaceView {

    private Paint sunPaint;
    private Paint mercuryPaint;
    private Paint venusPaint;
    private Paint earthPaint;
    private Paint marsPaint;
    private Paint jupiterPaint;
    private Paint saturnPaint;
    private Paint uranusPaint;
    private Paint neptunePaint;
    private Paint jupiterEyePaint;
    private Bitmap astronautBmp;
    private Bitmap ufoBmp;
    private Bitmap satRingBmp;
    private Bitmap neptRingBmp;

    /**
     * External Citation:
     * Date: 09/25/24
     * Problem: How can I identify which planet was selected?
     * Solution: Create an arraylist of elements that you can iterate through
     * Source: Nuxoll office hours
     */
    private ArrayList<PlanetElement> allPlanets = new ArrayList<>();

    /**
     * Constructor
     */
    public SolarSystemCanvas(Context context, AttributeSet attrs) {
        super(context, attrs);

        //make surface view visible
        setWillNotDraw(false);

        /**
         * External Citation:
         * Problem: How to create a new paint in Android Studio
         * Source: Nuxoll LizardCanvas.java from class lecture
         * Solution: Use setColor and setStyle methods
         */

        //initialize all colors
        sunPaint = new Paint();
        sunPaint.setColor(0xFFebbd34);
        sunPaint.setStyle(Paint.Style.FILL);

        mercuryPaint = new Paint();
        mercuryPaint.setColor(0xFF7d725c);
        mercuryPaint.setStyle(Paint.Style.FILL);

        venusPaint = new Paint();
        venusPaint.setColor(0xFF804236);
        venusPaint.setStyle(Paint.Style.FILL);

        earthPaint = new Paint();
        earthPaint.setColor(0xFF42a8b8);
        earthPaint.setStyle(Paint.Style.FILL);

        marsPaint = new Paint();
        marsPaint.setColor(0xFFd1442e);
        marsPaint.setStyle(Paint.Style.FILL);

        jupiterPaint = new Paint();
        jupiterPaint.setColor(0xFFdb9d67);
        jupiterPaint.setStyle(Paint.Style.FILL);

        saturnPaint = new Paint();
        saturnPaint.setColor(0xFFc7a773);
        saturnPaint.setStyle(Paint.Style.FILL);

        uranusPaint = new Paint();
        uranusPaint.setColor(0xFF598891);
        uranusPaint.setStyle(Paint.Style.FILL);

        neptunePaint = new Paint();
        neptunePaint.setColor(0xFF4e5a96);
        neptunePaint.setStyle(Paint.Style.FILL);

        jupiterEyePaint = new Paint();
        jupiterEyePaint.setColor(0xFF8f3c29);
        jupiterEyePaint.setStyle(Paint.Style.FILL);

        /**
         * External Citation
         * Problem: How to load and scale images into a surface view
         * Source: Nuxoll LizardCanvas.java from class lecture
         * Solution: Create a Bitmap
         */

        //initialize and resize all bitmaps
        astronautBmp = BitmapFactory.decodeResource(getResources(), R.drawable.astronaut);
        astronautBmp = Bitmap.createScaledBitmap(astronautBmp, 150,150,false);

        ufoBmp = BitmapFactory.decodeResource(getResources(), R.drawable.ufo);
        ufoBmp = Bitmap.createScaledBitmap(ufoBmp, 200, 200, false);

        satRingBmp = BitmapFactory.decodeResource(getResources(), R.drawable.saturn_ring);
        satRingBmp = Bitmap.createScaledBitmap(satRingBmp, 1050, 1050, false);

        neptRingBmp = BitmapFactory.decodeResource(getResources(), R.drawable.neptune_ring);
        neptRingBmp  =Bitmap.createScaledBitmap(neptRingBmp, 300, 300, false);

    }

    /**
     * External citations 09/19/24
     * Outside image used for astronaut.
     * Source: https://pngtree.com/freepng/aerospace-astronaut-cartoon-illustration_4524462.html?share=3&ssp_iabi=1683136563773
     *
     * Outside image used for UFO
     * Source: https://pngtree.com/freepng/element-colorful-ufo-illustration_4088803.html?sce=sol_pin
     *
     * External Citation 09/24/24
     * Problem: Wanted to make each editable element an object
     * Source: Spot.java from class lecture written by Nuxoll
     * Solution: Create an element class and create instances of class
     *
     * onDraw Class creates and draws planet element objects. Also draws bitmap static images.
     */

    @Override
    protected void onDraw(Canvas canvas) {
        setBackgroundColor(0xFF181924);

        //create all Planet Elements and add them to ArrayList
        PlanetElement sun = new PlanetElement("Sun",(float)-400,(float)550,(float)700, sunPaint);
        allPlanets.add(sun);

        PlanetElement mercury = new PlanetElement("Mercury",(float)355,(float)545,(float)20,mercuryPaint);
        allPlanets.add(mercury);

        PlanetElement venus = new PlanetElement("Venus",(float)453,(float)500,(float)30,venusPaint);
        allPlanets.add(venus);

        PlanetElement earth = new PlanetElement("Earth",(float)515,(float)550,(float)30,earthPaint);
        allPlanets.add(earth);

        PlanetElement mars = new PlanetElement("Mars",(float)605,(float)540,(float)20,marsPaint);
        allPlanets.add(mars);

        PlanetElement jupiter = new PlanetElement("Jupiter",(float)900,(float)570,(float)175,jupiterPaint);
        allPlanets.add(jupiter);

        PlanetElement saturn = new PlanetElement("Saturn",(float)1350,(float)590,(float)150,saturnPaint);
        allPlanets.add(saturn);

        PlanetElement uranus = new PlanetElement("Uranus",(float)1700,(float)540,(float)65,uranusPaint);
        allPlanets.add(uranus);

        PlanetElement neptune = new PlanetElement("Neptune",(float)1900,(float)570,(float)60,neptunePaint);
        allPlanets.add(neptune);

        //draw all PlanetElements in array list
        for(int i = 0; i < allPlanets.size(); i++) {
            allPlanets.get(i).draw(canvas);
        }

        //draw all bitMap/non editable/static elements
        //paint is just a placeholder to fulfill parameter requirement

        canvas.drawOval(980,600,1040,630, jupiterEyePaint);

        canvas.drawBitmap(satRingBmp,890,50,sunPaint);

        canvas.drawBitmap(neptRingBmp, 1760,410, sunPaint);

        canvas.drawBitmap(astronautBmp, 1700, 65, sunPaint);

        canvas.drawBitmap(ufoBmp,400,900, sunPaint);
    }

    /**
     * Getter method that returns ArrayList for allPlanets created
     */
    public ArrayList<PlanetElement> getAllPlanets() {
        return allPlanets;
    }
}
