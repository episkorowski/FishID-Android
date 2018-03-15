package org.tensorflow.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Eric on 3/2/2018.
 */

public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, org.tensorflow.demo.DatabaseActivity.class);
        startActivity(intent);
        finish();
    }
}
