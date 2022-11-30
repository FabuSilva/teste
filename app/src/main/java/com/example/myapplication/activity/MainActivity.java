package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.fragment.FragmentListaAlarmes;
import com.example.myapplication.model.Alarme;
import com.example.myapplication.recyclerView.RecyclerViewAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;
    ArrayList<Alarme> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        chamarFragment();

//        recyclerView = findViewById(R.id.recycle);
//        lista = new ArrayList<Alarme>();
//        lista.add(new Alarme("Dipirona","14/11/2022","10 20 01"));
//        lista.add(new Alarme("Anti-Alergico","17/11/2022","10 20 01"));
//        adapter = new RecyclerViewAdapter(MainActivity.this,lista);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this,
//                LinearLayoutManager.VERTICAL, false);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(adapter);
    }


    public void chamarFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,new FragmentListaAlarmes());
        fragmentTransaction.commit();
    }
}