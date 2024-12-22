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

public class LoginActivity extends AppCompatActivity {

    private EditText etCorreo, etPassword;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etCorreo = findViewById(R.id.etCorreo);
        etPassword = findViewById(R.id.etPassword);

        dbHelper = new DatabaseHelper(this);
    }

    public void Iniciar(View view) {
        String correo = etCorreo.getText().toString();
        String password = etPassword.getText().toString();

        Usuario usuario = dbHelper.iniciarSesion(correo, password);

        if (usuario != null) {
            Intent intent = new Intent(this, IndexActivity.class);
            intent.putExtra("nombreUsuario", usuario.getNombreUsuario());
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(LoginActivity.this, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show();
        }
    }

    public void IrRegistro(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}