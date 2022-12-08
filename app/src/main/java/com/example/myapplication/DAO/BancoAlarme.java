package com.example.myapplication.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BancoAlarme extends SQLiteOpenHelper {

    private static final String DATABASE_NOME = "meusMedicamentos";
    private static final int DATABASE_VERSAO = 1;
    private static final String TABELA = "alarmes";
    private static final String ID_TABELA = "id";
    private static final String MEDICAMENTO_TABELA = "nomeMedicamento";
    private static final String DATA_TABELA = "dataFinal";
    private static final String HORA_TABELA = "horarioSelecionado";
    private static final String FREQUENCIA_TABELA = "frequancia";


    public BancoAlarme(Context context) {
        super(context, DATABASE_NOME, null, DATABASE_VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String info = "CREATE TABLE " + TABELA + " ( "
                + ID_TABELA + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + MEDICAMENTO_TABELA + " TEXT, "
                + HORA_TABELA + " TEXT, "
                + DATA_TABELA + " TEXT,"
                + FREQUENCIA_TABELA + " INTEGER )";
        db.execSQL(info);
        db.close();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);
    }

    public static String getTabela() {
        return TABELA;
    }

    public static String getID() {
        return ID_TABELA;
    }

    public static String getNomeMed() {
        return MEDICAMENTO_TABELA;
    }

    public static String getData() {
        return DATA_TABELA;
    }

    public static String getHora() {
        return HORA_TABELA;
    }

    public static String getFrequencia() {
        return FREQUENCIA_TABELA;
    }
}
