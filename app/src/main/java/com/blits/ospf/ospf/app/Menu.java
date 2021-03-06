package com.blits.ospf.ospf.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import android.util.LruCache;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Menu extends Activity implements View.OnClickListener {

    Button buttonCost, buttonIPShow, buttonOSPF, buttonBaru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pilih_menu);

//        buttonBaru = (Button) findViewById(R.id.buttonBaru);
        buttonCost = (Button) findViewById(R.id.buttonCost);
        buttonIPShow = (Button) findViewById(R.id.buttonIPInterface);
        buttonOSPF = (Button) findViewById(R.id.buttonOSPF);

        buttonOSPF.setOnClickListener(this);
        buttonIPShow.setOnClickListener(this);
        buttonCost.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.buttonCost:
                intent = new Intent(getApplication(), Cost.class);
                startActivity(intent);
                break;
            case R.id.buttonIPInterface:
                intent = new Intent(getApplication(), InterfaceActivity.class);
                startActivity(intent);
                break;
            case R.id.buttonOSPF:
                intent = new Intent(getApplication(), Ospf.class);
                startActivity(intent);
                break;
        }

    }
}
