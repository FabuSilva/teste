package com.example.myapplication.fragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.myapplication.DAO.ControllerAlarme;
import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentCadastroRemedioBinding;
import com.example.myapplication.model.Alarme;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class FragmentCadastroRemedio extends Fragment {

    Alarme alarme;
    FragmentCadastroRemedioBinding binding;
    String horario = "";
    int frequancia, horaAtual, minutoAtal;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCadastroRemedioBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btCancelar();
        btSalvar();
        horaAlarme();
        dataAlarme();
        opcoesBotaoFrequencia();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    public void voltarParaHome() {
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setReorderingAllowed(true);
        fragmentTransaction.replace(R.id.frameLayout, new FragmentListaAlarmes());
        fragmentTransaction.commit();
    }

    public void btCancelar() {
        binding.btCancela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voltarParaHome();
            }
        });
    }

    public void horaAlarme() {
        Calendar calendar = Calendar.getInstance();
        int hora = calendar.get(Calendar.HOUR_OF_DAY);
        int minuto = calendar.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(),
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minuteOfDay) {
                        Calendar c = Calendar.getInstance();
                        c.set(Calendar.HOUR_OF_DAY,hourOfDay);
                        c.set(Calendar.MINUTE,minuteOfDay);
                        binding.horaRemedio.setText(String.format(Locale.getDefault(),"%02d:%02d",hourOfDay,minuteOfDay));
                        horaAtual = hourOfDay;
                        minutoAtal = minuteOfDay;
                        horario = binding.horaRemedio.getText().toString();
                        mostrandoHorarios();
                    }
                },hora,minuto,true
        );
        binding.horaRemedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog.show();
            }
        });
    }

    public void dataAlarme(){
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                Calendar dataSelecionada = Calendar.getInstance();
                dataSelecionada.set(year,month,dayOfMonth);
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                binding.dataFinal.setText(format.format(dataSelecionada.getTime()));

            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        binding.dataFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });
    }

    public void mostrandoHorarios(){
        int somaHora = horaAtual;
        int horaRezetada = horaAtual;
        if(frequancia == 0 && horario.equals("")){

        }else{
            if(frequancia == 1){
                somaHora = horaRezetada;
                binding.horario1.setText(somaHora +":"+ minutoAtal);
                binding.horario2.setText("-");
                binding.horario3.setText("-");
                binding.horario4.setText("-");
                binding.horario5.setText("-");
                binding.horario6.setText("-");

            }else if(frequancia ==2){
                somaHora = horaRezetada;
                binding.horario1.setText(somaHora +":"+ minutoAtal);
                somaHora = somaHora +12;
                binding.horario2.setText(validarHorario(somaHora) +":"+ minutoAtal);
                binding.horario3.setText("-");
                binding.horario4.setText("-");
                binding.horario5.setText("-");
                binding.horario6.setText("-");

            }else if(frequancia ==3){
                somaHora = horaRezetada;
                binding.horario1.setText(somaHora +":"+ minutoAtal);
                somaHora = somaHora +8;
                binding.horario2.setText(validarHorario(somaHora) +":"+ minutoAtal);
                somaHora = somaHora +8;
                binding.horario3.setText(validarHorario(somaHora) +":"+ minutoAtal);
                binding.horario4.setText("-");
                binding.horario5.setText("-");
                binding.horario6.setText("-");

            }else if(frequancia ==4){
                somaHora = horaRezetada;
                binding.horario1.setText(somaHora +":"+ minutoAtal);
                somaHora = somaHora +6;
                binding.horario2.setText(validarHorario(somaHora) +":"+ minutoAtal);
                somaHora = somaHora +6;
                binding.horario3.setText(validarHorario(somaHora) +":"+ minutoAtal);
                somaHora = somaHora +6;
                binding.horario4.setText(validarHorario(somaHora) +":"+ minutoAtal);
                binding.horario5.setText("-");
                binding.horario6.setText("-");

            }else if(frequancia ==5){
                somaHora = horaRezetada;
                binding.horario1.setText(somaHora +":"+ minutoAtal);
                somaHora = somaHora +4;
                binding.horario2.setText(validarHorario(somaHora) +":"+ minutoAtal);
                somaHora = somaHora +4;
                binding.horario3.setText(validarHorario(somaHora) +":"+ minutoAtal);
                somaHora = somaHora +4;
                binding.horario4.setText(validarHorario(somaHora) +":"+ minutoAtal);
                somaHora = somaHora +4;
                binding.horario5.setText(validarHorario(somaHora) +":"+ minutoAtal);
                somaHora = somaHora +4;
                binding.horario6.setText(validarHorario(somaHora) +":"+ minutoAtal);

            }else if(frequancia ==6){
                somaHora = horaRezetada;
                binding.horario1.setText(somaHora +":"+ minutoAtal);
                minutoAtal = minutoAtal +1;
                binding.horario2.setText(somaHora +":"+ minutoAtal);
                minutoAtal = minutoAtal +1;
                binding.horario3.setText(somaHora +":"+ minutoAtal);
                binding.horario4.setText("-");
                binding.horario5.setText("-");
                binding.horario6.setText("-");

            }
        }

    }

    public int validarHorario(int hora){
        if(hora >=24){
            hora = hora-24;
        }
        return hora;
    }

    public void opcoesBotaoFrequencia(){
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(getActivity(),R.array.opcoes, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.frequenciaMedicamento.setAdapter(arrayAdapter);
        binding.frequenciaMedicamento.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //String text = adapterView.getItemAtPosition(i).toString();
                frequancia = i;
                mostrandoHorarios();
                //Toast.makeText(getApplicationContext(),text+" "+frequancia,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void btSalvar() {
        binding.btSalva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pegarDados();
                voltarParaHome();
            }
        });
    }

    public void pegarDados() {
        Alarme alarme = new Alarme();
        ControllerAlarme crud = new ControllerAlarme(getActivity());
        alarme.setNomeMedicamento(binding.nomeMedicamento.getText().toString());
        alarme.setDataFinal(binding.dataFinal.getText().toString());
        alarme.setHorarioSelecionado(binding.horaRemedio.getText().toString());
        alarme.setFrequancia(frequancia);
//        String resultado;
//        resultado = crud.salvar(alarme);
//        Toast.makeText(getActivity(),resultado,Toast.LENGTH_SHORT).show();
        crud.salvar(alarme);

    }


}
