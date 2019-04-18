package com.sadhanas.crudsqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BuatDataActivity extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton1, ton2;
    EditText text1, text2, text3, text4, text5, text6, text7, text8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_data);

        dbHelper = new DataHelper(this);
        text2 = (EditText) findViewById(R.id.editText2);
        text3 = (EditText) findViewById(R.id.editText3);
        text4 = (EditText) findViewById(R.id.editText4);
        text5 = (EditText) findViewById(R.id.editText5);
        text6 = (EditText) findViewById(R.id.editText6);
        text7 = (EditText) findViewById(R.id.editText7);
        text8 = (EditText) findViewById(R.id.editText8);
        ton1  = (Button) findViewById(R.id.button1);
        ton2  = (Button) findViewById(R.id.button2);

        text3.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
        text4.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
        text5.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
        text6.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
        text7.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
        text8.setFilters(new InputFilter[] {new InputFilter.AllCaps()});

        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into unit(serial, model, tipe, kelurahan, kecamatan, kota, kodepos) values('" +
                        text2.getText().toString() + "','" +
                        text3.getText().toString() + "','" +
                        text4.getText().toString() + "','" +
                        text5.getText().toString() + "','" +
                        text6.getText().toString() + "','" +
                        text7.getText().toString() + "','" +
                        text8.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "Berhasil menambahkan data", Toast.LENGTH_LONG).show();
                ManualActivity.ma.RefreshList();
                finish();
            }
        });
        ton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }
}
