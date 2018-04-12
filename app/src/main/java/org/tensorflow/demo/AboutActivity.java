package org.tensorflow.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class AboutActivity extends AppCompatActivity {

    private static final String TAG = "AboutActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.data_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.switch_to_live:
                Log.d(TAG, "Switching to Live Mode");
                Intent liveIntent = new Intent(this, org.tensorflow.demo.ClassifierActivity.class);
                startActivity(liveIntent);
                finish();
                return true;

            case R.id.database:
                Log.d(TAG, "Switching to Database");
                Intent databaseIntent = new Intent(this, org.tensorflow.demo.DatabaseActivity.class);
                startActivity(databaseIntent);
                finish();
                return true;

            case R.id.about:
                Log.d(TAG, "Switching to About page");
                Intent aboutIntent = new Intent(this, org.tensorflow.demo.AboutActivity.class);
                startActivity(aboutIntent);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
