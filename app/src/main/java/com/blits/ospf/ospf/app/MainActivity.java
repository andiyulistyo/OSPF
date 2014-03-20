package com.blits.ospf.ospf.app;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private EditText editTextInput;
    private Button buttonNext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextInput = (EditText) findViewById(R.id.editTextInputRouter);
        buttonNext = (Button) findViewById(R.id.buttonSelanjutnyaInputRouter);
        buttonNext.setEnabled(false);

        editTextInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().trim().isEmpty())  {
                    buttonNext.setEnabled(true);
                } else  {
                    buttonNext.setEnabled(false);
                }
            }
        });

        buttonNext.setOnClickListener(this);
    }


    @SuppressWarnings("ConstantConditions")
    @Override
    public void onClick(View view) {
        // ambil nilai dari inputan  user
        int router = Integer.valueOf(editTextInput.getText().toString());

        // pass ke class selanjutnya
        Intent intent = new Intent(getApplication(), NamaRouter.class);
        intent.putExtra("router", router);
        startActivity(intent);
    }
}
