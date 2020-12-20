package com.lipisoft.toyshark.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";

    private static final String TABLE_NAME = "packet";
    private static final String ID = "id";
    private static final String CLIENT_IP = "client_ip";
    private static final String SERVER_IP = "server_ip";
    private static final String TIMESTAMP = "timestamp";
    private static final String PACKAGE_SIZE = "package_size";
    private static final String CONNECTION_TYPE = "connection_type";


    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CLIENT_IP + " TEXT" + "," +
                SERVER_IP + " TEXT" + "," +
                TIMESTAMP + " TEXT" + "," +
                PACKAGE_SIZE + " TEXT" + "," +
                CONNECTION_TYPE + " TEXT" +
                ")";


        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(PacketModel packetModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CLIENT_IP, packetModel.getClientIp());
        contentValues.put(SERVER_IP, packetModel.getServerIp());
        contentValues.put(TIMESTAMP, packetModel.getTimestamp());
        contentValues.put(PACKAGE_SIZE, packetModel.getPackageSize());
        contentValues.put(CONNECTION_TYPE, packetModel.getConnectionType());

        Log.d(TAG, "addData: Adding " + packetModel.toString() + " to " + TABLE_NAME);

        long result = db.insert(TABLE_NAME, null, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void clearDb(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);
        db.execSQL("VACUUM");
    }

    /**
     * Returns all the data from database
     *
     * @return
     */
    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }


}
