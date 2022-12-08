package com.example.myapplication.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ControllerAlarme extends SQLiteOpenHelper {

    private static final String DATABASE_NOME = "MeusMedicamentos";
    private static final int DATABASE_VERSAO = 1;
    private static final String TABELA = "Alarmes";
    private static final String ID_TABELA = "id";
    private static final String MEDICAMENTO_TABELA = "nomeMedicamento";
    private static final String DATA_TABELA = "dataFinal";
    private static final String HORA_TABELA = "horarioSelecionado";
    private static final String FREQUENCIA_TABELA = "frequancia";
    private static SQLiteDatabase instance;

    public static SQLiteDatabase getInstance() {
        return instance;
    }

    public ControllerAlarme(Context context) {
        super(context, DATABASE_NOME, null, DATABASE_VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String info = "CREATE TABLE IF NOT EXISTS " + TABELA + " ( "
                + ID_TABELA + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + MEDICAMENTO_TABELA + " VARCHAR, "
                + HORA_TABELA + " VARCHAR, "
                + FREQUENCIA_TABELA + " INTEGER,"
                + DATA_TABELA + " VARCHAR )";
        db.execSQL(info);
        db.close();

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
