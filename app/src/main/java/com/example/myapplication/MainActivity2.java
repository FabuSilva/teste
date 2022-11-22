package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.example.myapplication.databinding.ActivityMain2Binding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ActivityMain2Binding binding;
    String horario = "";
    int frequancia, horaAtual, minutoAtal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        opcoesBotaoFrequencia();
        dataAlarme();
        horaAlarme();
    }

    public void trocaTela2Para1(View view){
        Intent intent = new Intent(MainActivity2.this,MainActivity.class);
        startActivity(intent);
    }

    public void opcoesBotaoFrequencia(){
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,R.array.opcoes, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.frequenciaMedicamento.setAdapter(arrayAdapter);
        binding.frequenciaMedicamento.setOnItemSelectedListener(this);

    }

    public void horaAlarme(){
        Calendar calendar = Calendar.getInstance();
        int hora = calendar.get(Calendar.HOUR_OF_DAY);
        int minuto = calendar.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity2.this,
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
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
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
}