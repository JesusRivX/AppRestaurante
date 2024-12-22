package com.example.app.Vista;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.app.R;

public class IndexActivity extends AppCompatActivity {

    private TextView tvNombreUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        tvNombreUsuario = findViewById(R.id.tvNombreUsuario);

        String nombreUsuario = getIntent().getStringExtra("nombreUsuario");
        String usuario = getIntent().getStringExtra("usuario");

        String mensajeBienvenida = "Bienvenido, " + (nombreUsuario != null ? nombreUsuario : usuario);
        tvNombreUsuario.setText(mensajeBienvenida);
    }
}