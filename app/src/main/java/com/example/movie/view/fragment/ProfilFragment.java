package com.example.movie.view.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movie.Databse.AppDatabase;
import com.example.movie.Databse.DataDiri;
import com.example.movie.R;
import com.example.movie.adapter.DataDiriAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfilFragment extends AppCompatActivity  {

    private AppDatabase appDatabase;
    private RecyclerView rc;

    public ProfilFragment() {
        // Required empty public constructor
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profil);

        appDatabase = AppDatabase.initDB(this);

        rc = findViewById(R.id.rv_data);
        rc.setHasFixedSize(true);

    }
    @Override
    protected void onResume() {
        super.onResume();

        read();
    }

    private void read() {
        DataDiri[] list = appDatabase.dao().getData();

        rc.setLayoutManager(new LinearLayoutManager(this));
        DataDiriAdapter dataDiriAdapter = new DataDiriAdapter(list, this);
        rc.setAdapter(dataDiriAdapter);
    }

}
