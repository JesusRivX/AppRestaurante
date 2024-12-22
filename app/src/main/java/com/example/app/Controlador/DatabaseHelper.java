package com.example.app.Controlador;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.app.Modelo.Usuario;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) {
        super(context, "app", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE usuarios (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombreUsuario TEXT," +
                "correo TEXT," +
                "password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        onCreate(db);
    }

    public boolean registrarUsuario(Usuario usuario) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nombreUsuario", usuario.getNombreUsuario());
        values.put("correo", usuario.getCorreo());
        values.put("password", usuario.getPassword());

        long result = db.insert("usuarios", null, values);
        db.close();
        return result != -1;
    }

    public Usuario iniciarSesion(String correo, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("usuarios",
                new String[]{"nombreUsuario", "correo", "password"},
                "correo = ? AND password = ?",
                new String[]{correo, password},
                null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            String nombreUsuario = cursor.getString(0);
            cursor.close();
            db.close();
            return new Usuario(nombreUsuario, correo, password);
        }

        db.close();
        return null;
    }
}
