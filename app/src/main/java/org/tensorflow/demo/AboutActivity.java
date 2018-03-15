package org.tensorflow.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

/**
 * Created by Eric on 3/8/2018.
 */

public class AboutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View aboutPage = new AboutPage(this)
                .isRTL(false)
                //.setImage(R.drawable.dummy_image)
                .addItem(new Element().setTitle("Version 0.1"))
                .addEmail("ericpiskorowski@gmail.com")
                .addWebsite("https://episkorowski.github.io/")
                //.addPlayStore()
                .addGitHub("episkorowski")
                //.addItem(getCopyRightsElement())
                .create();

        setContentView(aboutPage);

    }
}