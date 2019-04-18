package com.sadhanas.crudsqlite;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class LihatActivity extends AppCompatActivity implements View.OnClickListener {
    ConnectivityManager conMgr;
    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton1, ton2;
    TextView text1, text2, text3, text4, text5, text6, text7, text8, sts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat);
        conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        dbHelper = new DataHelper(this);
        text1 = (TextView) findViewById(R.id.textView1);
        text2 = (TextView) findViewById(R.id.textView2);
        text3 = (TextView) findViewById(R.id.textView3);
        text4 = (TextView) findViewById(R.id.textView4);
        text5 = (TextView) findViewById(R.id.textView5);
        text6 = (TextView) findViewById(R.id.textView6);
        text7 = (TextView) findViewById(R.id.textView7);
        text8 = (TextView) findViewById(R.id.textView8);
        sts   = (TextView) findViewById(R.id.stat);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM unit WHERE serial = '" +
                getIntent().getStringExtra("serial") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(0).toString());
            text2.setText(cursor.getString(1).toString());
            text3.setText(cursor.getString(2).toString());
            text4.setText(cursor.getString(3).toString());
            text5.setText(cursor.getString(4).toString());
            text6.setText(cursor.getString(5).toString());
            text7.setText(cursor.getString(6).toString());
            text8.setText(cursor.getString(7).toString());
        }
        ton2 = (Button) findViewById(R.id.button1);
        ton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });
        ton1 = findViewById(R.id.button2);
        ton1.setOnClickListener(this);
    }

    public  void addData() {
        //final String id_user= tvId.getText().toString().trim();
        final String serial = text2.getText().toString();
        final String model  = text3.getText().toString();
        final String tipe   = text4.getText().toString();
        final String kel    = text5.getText().toString();
        final String kec    = text6.getText().toString();
        final String kota   = text7.getText().toString();
        final String kodepos= text8.getText().toString();

        class AddData extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(LihatActivity.this,"Menambahkan...","Harap Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
//                sts.setText("data singkron");
                Toast.makeText(LihatActivity.this,s,Toast.LENGTH_LONG).show();
                finish();
            }

            @SuppressLint("WrongThread")
            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                //params.put(Value.KEY_ID_USER, id_user);
                params.put(Value.KEY_SERI,serial);
                params.put(Value.KEY_TIPE_M, model);
                params.put(Value.KEY_SPINNER, tipe);
                params.put(Value.KEY_KELURAHAN, kel);
                params.put(Value.KEY_KECAMATAN, kec);
                params.put(Value.KEY_KOTA, kota);
                params.put(Value.KEY_KODEPOS, kodepos);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Value.URL_ADD, params);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("delete from unit where serial = '" + serial + "'");
                return res;
            }
        }
        AddData ad = new AddData();
        ad.execute();
    }

    @Override
    public void onClick(View v) {
        if (conMgr.getActiveNetworkInfo() != null && conMgr.getActiveNetworkInfo().isAvailable() && conMgr.getActiveNetworkInfo().isConnected()) {
            addData();
        } else {
            Toast.makeText(getApplicationContext() ,"Tidak ada koneksi, mohon sync kembali saat anda terhubung dengan internet", Toast.LENGTH_LONG).show();
        }
    }
}
