package com.blits.ospf.ospf.app;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.view.Menu;
import android.widget.Button;
import android.widget.ListView;

import com.blits.ospf.ospf.app.adapter.NamaRouterAdapter;

import java.util.ArrayList;
import java.util.List;


public class NamaRouter extends ListActivity implements View.OnClickListener {

    private NamaRouterAdapter routerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_nama_router);

        Button buttonNext = (Button) findViewById(R.id.buttonNamaRouter);
        buttonNext.setOnClickListener(this);

        // ambil nilai dari intent
        @SuppressWarnings("ConstantConditions") int router = getIntent().getExtras().getInt("router");

        // buat hint
        List<String> nama = new ArrayList<String>();

        for (int i = 0; i < router; i++) {
            nama.add("Nama Router ke : "+i);
        }

        // set data ke adapter
        routerAdapter = new NamaRouterAdapter(nama, NamaRouter.this);
        // set item focus true
        getListView().setItemsCanFocus(true);

        ListView listView = getListView();
        listView.setItemsCanFocus(true);

        // set adapter ke listview
        setListAdapter(routerAdapter);
    }

    @Override
    public void onClick(View view) {
        ArrayList<String> arrayList = new ArrayList<>();

        // get value dari inputan di listview
        for (int i = 0; i < routerAdapter.getCount(); i++) {
            // ambil data dari adapter
            arrayList.add(routerAdapter.hashMap.get(i));
        }

        // panggil class selanjutnya dan kirim value nama yang telah
        // diinputkan
        Intent intent = new Intent(NamaRouter.this, InputDetailRouter.class);
        intent.putStringArrayListExtra("nama", arrayList);
        startActivity(intent);
    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.main, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getItemId() == R.id.next) {
//            ArrayList<String> arrayList = new ArrayList<>();
//
//            // get value dari inputan di listview
//            for (int i = 0; i < routerAdapter.getCount(); i++) {
//                // ambil data dari adapter
//                arrayList.add(routerAdapter.hashMap.get(i));
//            }
//
//            // panggil class selanjutnya dan kirim value nama yang telah
//            // diinputkan
//            Intent intent = new Intent(NamaRouter.this, InputDetailRouter.class);
//            intent.putStringArrayListExtra("nama", arrayList);
//            startActivity(intent);
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
