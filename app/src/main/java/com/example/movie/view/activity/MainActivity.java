package com.example.movie.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.movie.Databse.AppDatabase;
import com.example.movie.Databse.DataDiri;
import com.example.movie.R;
import com.example.movie.view.fragment.NowshowingFragment;
import com.example.movie.view.fragment.UpcomingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
        private EditText etEmail, etPassword;
        private Button btnMasuk;
        private AppDatabase appDatabase;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

        appDatabase = appDatabase.initDB(getApplicationContext());
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnMasuk = findViewById(R.id.btnMasuk);

        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
                Intent intent = new Intent(getApplicationContext(), MainActivityMovie.class);
                startActivity(intent);
            }
        });
        }

    private void insertData() {
            try {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                DataDiri item = new DataDiri();
                item.setEmail(email);
                item.setPassword(password);

                appDatabase.dao().insertData(item);
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_SHORT).show();

            } catch (Exception e){
                Toast.makeText(getApplicationContext(), "Harap Diisi", Toast.LENGTH_SHORT).show();
            }
    etEmail.setText("");
            etPassword.setText("");
    }


}
