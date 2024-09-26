/**
 * @author Megan Ou
 * @date 09/26/24
 */
package edu.up.ou_megan_hw_1_custom_coloring;

import android.graphics.Canvas;
import android.graphics.Paint;

public class PlanetElement {
    private String planetName;
    private float planetX;
    private float planetY;
    private float planetRadius;
    private Paint planetColor;

    public PlanetElement(String initName, Float initX, Float initY, Float initRadius, Paint initPaint) {
        planetName = initName;
        planetX = initX;
        planetY = initY;
        planetRadius = initRadius;
        planetColor = initPaint;
    }

    /**
     * Getter method for planet name to help with editing a TextView
     * when specific elements are selected
     */
    public String getPlanetName() {
        return this.planetName;
    }

    /**
     * Getter method for current planet radius
     */
    public float getPlanetRadius () {
        return this.planetRadius;
    }

    /**
     * Getter method for current planet paint
     */
    public Paint getPlanetColor() {
        return this.planetColor;
    }

    /**
     * Setter method for current planet paint
     */
    public void setPlanetColor(int newColor) {
        planetColor.setColor(newColor);
    }

    /**
     * External Citation
     * Date: 09/24/24
     * Problem: How to create draw method to draw a generic planet
     * Solution: Use structure from Spot.java written by Nuxoll in CS301 lecture
     */

    public void draw(Canvas canvas) {
        canvas.drawCircle(planetX, planetY, planetRadius, planetColor);
    }

    /**
     * Helper method to see if element contains a certain point
     * Use of pythagorean theorem to calculate distance
     *
     * External Citation
     * Date: 09/24/24
     * Problem: How to take square root of numbers
     * Solution: Use Math.sqrt()
     * Source: CustomCircle.java provided by Nuxoll on CS301 Moodle
     */
    public boolean inElement (float xVal, float yVal, float currPlanetRadius) {
        float distanceSq = ((xVal - planetX) * (xVal - planetX)) +
                ((yVal - planetY) * (yVal - planetY));
        double distance = Math.sqrt(distanceSq);

        if (distance <= currPlanetRadius) {
            return true;
        }

        else {
            return false;
        }
    }
}
