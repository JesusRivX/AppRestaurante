package com.example.app.Vista;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.app.Controlador.DatabaseHelper;
import com.example.app.Modelo.Usuario;
import com.example.app.R;

public class RegisterActivity extends AppCompatActivity {

    private EditText etNombre, etCorreo, etPassword;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etNombre = findViewById(R.id.etNombre);
        etCorreo = findViewById(R.id.etCorreo);
        etPassword = findViewById(R.id.etPassword);

        dbHelper = new DatabaseHelper(this);
    }

    public void Registro(View view) {
        String nombre = etNombre.getText().toString();
        String correo = etCorreo.getText().toString();
        String password = etPassword.getText().toString();

        if (!nombre.isEmpty() && !correo.isEmpty() && !password.isEmpty()) {
            Usuario usuario = new Usuario(nombre, correo, password);
            if (dbHelper.registrarUsuario(usuario)) {
                Toast.makeText(this, "Usuario registrado exitosamente", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Error al registrar usuario", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
        }
    }

    public void IrLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}