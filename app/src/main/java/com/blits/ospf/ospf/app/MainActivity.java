package com.blits.ospf.ospf.app;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.devspark.appmsg.AppMsg;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private EditText editTextInput;
    private Button buttonNext;
    private TextView textView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextInput = (EditText) findViewById(R.id.editTextInputRouter);
        buttonNext = (Button) findViewById(R.id.buttonSelanjutnyaInputRouter);

        textView = (TextView) findViewById(R.id.texxx);

        buttonNext.setOnClickListener(this);
    }


    @SuppressWarnings("ConstantConditions")
    @Override
    public void onClick(View view) {
        int router = 0;

        // ambil nilai dari inputan  user
        if (editTextInput.getText().toString().trim().isEmpty()) {
            AppMsg.makeText(this, "Banyak Router Masih Kosong", AppMsg.STYLE_ALERT).show();

            editTextInput.requestFocus();
        } else {
            router = Integer.valueOf(editTextInput.getText().toString());

            // pass ke class selanjutnya
            Intent intent = new Intent(getApplication(), NamaRouter.class);

            intent.putExtra("router", router);
            startActivity(intent);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        AppMsg.cancelAll();
    }
}
