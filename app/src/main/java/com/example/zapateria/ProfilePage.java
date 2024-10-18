package com.example.zapateria;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ProfilePage extends AppCompatActivity {

    TextView userName, userEmail, userPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        // Inicializar vistas
        userName = findViewById(R.id.user_name);
        userEmail = findViewById(R.id.user_email);
        userPhone = findViewById(R.id.user_phone);

        // Aquí puedes obtener los datos del usuario desde Firebase o cualquier base de datos
        userName.setText("Juan Pérez");  // Ejemplo
        userEmail.setText("juanperez@example.com");  // Ejemplo
        userPhone.setText("+123456789");  // Ejemplo
    }
}
