package org.tensorflow.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseActivity extends AppCompatActivity {

    private static final String TAG = "DatabaseActivity";
    private ListView mFishListView;
    private ArrayList<HashMap<String, String>> listMap;
    private SimpleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.database_activity);
        updateUI();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.data_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void updateUI() {
        mFishListView = (ListView) findViewById(R.id.list_fish);
        DbHelper db = new DbHelper(this);
        listMap = db.getAllFish();
        mAdapter = new SimpleAdapter(this,
                listMap,
                R.layout.fish_item,
                new String[]{"line1", "line2"},
                new int[]{R.id.fish_name, R.id.fish_species});
        mFishListView.setAdapter(mAdapter);
        db.close();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
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
