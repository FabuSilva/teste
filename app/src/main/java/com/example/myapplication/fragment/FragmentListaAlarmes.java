package com.example.myapplication.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentListaAlarmesBinding;
import com.example.myapplication.model.Alarme;
import com.example.myapplication.recyclerView.RecyclerViewAdapter;

import java.util.ArrayList;


public class FragmentListaAlarmes extends Fragment {

    FragmentListaAlarmesBinding binding;
    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;
    ArrayList<Alarme> lista;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentListaAlarmesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        chamarTelaCadastro();
        recyclerView = binding.recycle;
        lista = new ArrayList<Alarme>();
        lista.add(new Alarme("Dipirona","14/11/2022","10 20 01"));
        lista.add(new Alarme("Anti-Alergico","17/11/2022","10 20 01"));
        adapter = new RecyclerViewAdapter(getActivity(),lista);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    public void chamarTelaCadastro(){
        binding.btFlutuante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setReorderingAllowed(true);
                fragmentTransaction.replace(R.id.frameLayout,new FragmentCadastroRemedio());
                fragmentTransaction.commit();

            }
        });
    }
}