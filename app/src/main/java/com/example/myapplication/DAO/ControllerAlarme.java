package com.example.myapplication.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.model.Alarme;

import java.util.ArrayList;
import java.util.List;

public class ControllerAlarme {

    private SQLiteDatabase db;
    private BancoAlarme banco;

    public ControllerAlarme(Context context) {
        banco = new BancoAlarme(context);
    }

    public String salvar(Alarme a) {
        try {
            long resultado;
            ContentValues valores = new ContentValues();
            db = banco.getWritableDatabase();
            valores.put(BancoAlarme.getNomeMed(), a.getNomeMedicamento());
            valores.put(BancoAlarme.getHora(), a.getHorarioSelecionado());
            valores.put(BancoAlarme.getData(), a.getDataFinal());
            valores.put(BancoAlarme.getFrequencia(), a.getFrequancia());

            resultado = db.insert(BancoAlarme.getTabela(), null, valores);
            db.close();
            if (resultado == -1) {
                return "ERRO ao cadastrar alarme";
            } else {
                return "Alarme salvo com sucesso";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public void alterar(Alarme a) {

    }

    public void deletar(int id) {

    }

    public Cursor listarDados() {
        try {
            Cursor cursor;
            String[] campos = {BancoAlarme.getID(), BancoAlarme.getNomeMed(), BancoAlarme.getData(), BancoAlarme.getFrequencia()};
            db = banco.getReadableDatabase();
            cursor = db.query(BancoAlarme.getTabela(), campos, null, null, null, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            db.close();
            return cursor;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }


}
