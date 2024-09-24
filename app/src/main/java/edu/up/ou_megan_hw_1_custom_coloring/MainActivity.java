/**
 * @Author: Megan Ou
 * @Date: 09/22/24
 */
package edu.up.ou_megan_hw_1_custom_coloring;

import android.os.Bundle;
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
        TextView tvGreenVal = findViewById(R.id.tvSbGreen);
        TextView tvBlueVal = findViewById(R.id.tvBlueVal);


    }
}