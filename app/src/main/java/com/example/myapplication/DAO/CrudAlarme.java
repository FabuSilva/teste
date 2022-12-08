package com.example.myapplication.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.model.Alarme;

import java.util.ArrayList;
import java.util.List;

public class CrudAlarme {

    public void salvar(Alarme a) {
        SQLiteDatabase conexao = ControllerAlarme.getInstance();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nomeMedicamento", a.getNomeMedicamento());
        contentValues.put("horarioSelecionado", a.getHorarioSelecionado());
        contentValues.put("dataFinal", a.getDataFinal());
        contentValues.put("frequencia", a.getFrequancia());
        conexao.insert("Alarmes", null, contentValues);
        conexao.close();
    }

    public void alterar(Alarme a) {

    }

    public void deletar(int id) {

    }

    public List<Alarme> listar() {
        List<Alarme> alarmeList = new ArrayList<Alarme>();
        try {
            SQLiteDatabase conexao = ControllerAlarme.getInstance();
            Cursor cursor = conexao.query("Alarmes", new String[]{"nomeMedicamento", "horarioSelecionado", "dataSelecionada"},
                    null, null, null, null, null);

            if (cursor.moveToFirst()) {
                do {
                    Alarme alarme = new Alarme();
                    alarme.setId(cursor.getInt(0));
                    alarme.setNomeMedicamento(cursor.getString(1));
                    alarme.setHorarioSelecionado(cursor.getString(2));
                    alarme.setDataFinal(cursor.getString(3));
                    alarme.setFrequancia(cursor.getInt(4));
                    alarmeList.add(alarme);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return alarmeList;

    }
}
