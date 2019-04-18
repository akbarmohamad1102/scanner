package com.sadhanas.crudsqlite;

public class Value {
    String value;
    String message;

    public String getValue() {
        return value;
    }
    public String getMessage() {
        return message;
    }


    public static final String URL_ADD  ="https://cyclic-loaf.000webhostapp.com/insert_manual.php";
    public static final String URL_LOGIN = "https://cyclic-loaf.000webhostapp.com/login.php/";

    public static final String URL_SAVE ="https://cyclic-loaf.000webhostapp.com/insert_unit.php/";
    public static final String URL_SELECT = "http://qr.sadhanas.co.id/select.php";
    public static final String URL_TAMPIL = "https://cyclic-loaf.000webhostapp.com/tampil.php?id=";
    public static final String URL_UPDATE= "https://cyclic-loaf.000webhostapp.com/update.php";
    public static final String URL_DELETE= "https://cyclic-loaf.000webhostapp.com/delete.php?id=";

    //Dibawah ini merupakan Kunci yang akan digunakan untuk mengirim permintaan ke Skrip PHP, insert manual
    public static final String KEY_U_ID         = "id";
    public static final String KEY_SERI         = "seri";
    public static final String KEY_TIPE_M       = "tipe";
    public static final String KEY_SPINNER      = "spinner";
    //public static final String KEY_ALAMAT       = "alamat"; //desg itu variabel untuk posisi
    public static final String KEY_KELURAHAN    = "kelurahan"; //desg itu variabel untuk posisi
    public static final String KEY_KECAMATAN    = "kecamatan"; //desg itu variabel untuk posisi
    public static final String KEY_KOTA         = "kota"; //salary itu variabel untuk gajih
    public static final String KEY_KODEPOS      = "kodepos"; //salary itu variabel untuk gajih
    //Dibawah ini merupakan Kunci yang akan digunakan untuk mengirim permintaan ke Skrip PHP, insert unit
    public static final String KEY_ID_USER      = "id_user";
    public static final String KEY_SERIAL       = "serial";
    public static final String KEY_MODEL        = "model";
    public static final String KEY_TIPE         = "tipe";
    public static final String KEY_LAT          = "lat"; //desg itu variabel untuk posisi
    public static final String KEY_LNG          = "lng"; //desg itu variabel untuk posisi

    //JSON Tags
    public static final String TAG_JSON_ARRAY   ="result";
    public static final String TAG_ID           = "id";
    public static final String TAG_SERIAL       = "serial";
    public static final String TAG_ALAMAT       = "alamat";
    public static final String TAG_KOTA         = "kota";
    public static final String TAG_KODEPOS      = "kodepos";

    //ID karyawan
    public static final String U_ID             = "id_user";
}
