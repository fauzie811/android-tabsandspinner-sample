package com.fauzie.sample.tabsspinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Fauzie on 11/2/2014.
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {
    private Button btnTabs;
    private Button btnSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTabs = (Button) findViewById(R.id.button_tabs);
        btnSpinner = (Button) findViewById(R.id.button_spinner);

        btnTabs.setOnClickListener(this);
        btnSpinner.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btnTabs) {
            Intent i = new Intent(this, TabsActivity.class);
            startActivity(i);
        } else if (view == btnSpinner) {
            Intent i = new Intent(this, SpinnerActivity.class);
            startActivity(i);
        }
    }
}
