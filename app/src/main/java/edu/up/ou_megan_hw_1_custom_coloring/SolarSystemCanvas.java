/**
 * @Author: Megan Ou
 * @Date: 09/22/24
 */
package edu.up.ou_megan_hw_1_custom_coloring;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

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
         * Problem: How to load images into a surface view
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
     */

    @Override
    protected void onDraw(Canvas canvas) {
        setBackgroundColor(0xFF181924);

        //draw Sun - EDITABLE ELEMENT
        canvas.drawCircle(-400,550,700, sunPaint);

        //draw Mercury - EDITABLE ELEMENT
        canvas.drawCircle(355,545,20, mercuryPaint);

        //draw Venus - EDITABLE ELEMENT
        canvas.drawCircle(435,500,30, venusPaint);

        //draw Earth - EDITABLE ELEMENT
        canvas.drawCircle(510, 550, 30, earthPaint);

        //draw Mars - EDITABLE ELEMENT
        canvas.drawCircle(605,540, 20, marsPaint);

        //draw Jupiter - EDITABLE ELEMENT
        canvas.drawCircle(900,570, 175, jupiterPaint);

        //draw Jupiter's Eye - STATIC ELEMENT
        canvas.drawOval(980,600,1040,630, jupiterEyePaint);

        //draw Saturn - EDITABLE ELEMENT
        canvas.drawCircle(1350,590, 150, saturnPaint);

        //draw Saturn's Rings - STATIC ELEMENT
        canvas.drawBitmap(satRingBmp,890,50,sunPaint);

        //draw Uranus - EDITABLE ELEMENT
        canvas.drawCircle(1700, 540, 65, uranusPaint);

        //draw Neptune - EDITABLE ELEMENT
        canvas.drawCircle(1900, 570, 60, neptunePaint);

        //draw Neptune's Ring - STATIC ELEMENT
        canvas.drawBitmap(neptRingBmp, 1760,410, sunPaint);

        //draw astronaut - STATIC ELEMENT
        //paint is just a placeholder to fulfill parameter requirement
        canvas.drawBitmap(astronautBmp, 1700, 65, sunPaint);

        //draw UFO - STATIC ELEMENT
        canvas.drawBitmap(ufoBmp,400,900, sunPaint);
    }
}
