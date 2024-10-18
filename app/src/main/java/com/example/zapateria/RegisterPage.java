package com.example.zapateria;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterPage extends AppCompatActivity {

    TextInputEditText editTextUsername, editTextCedula, editTextTelefono, editTextEmail, editTextPassword;
    Button signUp;
    TextView signIn;
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register_page);

        editTextUsername = findViewById(R.id.username);
        editTextCedula = findViewById(R.id.cedula);
        editTextTelefono = findViewById(R.id.telefono);
        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.password);
        signIn = findViewById(R.id.sign_in);
        signUp = findViewById(R.id.sign_up);

        signIn.setOnClickListener(v -> {
            Intent intent = new Intent(RegisterPage.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        signUp.setOnClickListener(v -> {
            String username, cedula, telefono, email, password;
            username = String.valueOf(editTextUsername.getText());
            cedula = String.valueOf(editTextCedula.getText());
            telefono = String.valueOf(editTextTelefono.getText());
            email = String.valueOf(editTextEmail.getText());
            password = String.valueOf(editTextPassword.getText());

            if (TextUtils.isEmpty(username)) {
                Toast.makeText(RegisterPage.this, "Ingresa un nombre de usuario", Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(cedula)) {
                Toast.makeText(RegisterPage.this, "Ingresa una cédula", Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(telefono)) {
                Toast.makeText(RegisterPage.this, "Ingresa un número de teléfono", Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(email)) {
                Toast.makeText(RegisterPage.this, "Ingresa un correo electrónico", Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(password)) {
                Toast.makeText(RegisterPage.this, "Ingresa una contraseña", Toast.LENGTH_SHORT).show();
                return;
            }

            firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Toast.makeText(RegisterPage.this, "Registro correcto", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RegisterPage.this, HomePage.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(RegisterPage.this, "Error al registrar", Toast.LENGTH_SHORT).show();
                        }
                    });
        });
    }
}
